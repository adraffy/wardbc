package com.antistupid.wardbc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

public class DBC {
    
    /*
    static public byte[] readCriticalFile(Path path) {
        try {
            return Files.readAllBytes(path);
        } catch (IOException err) {
            System.err.println("Critical file failed: " + path);
            err.printStackTrace();
            System.exit(1);
            return null;
        }
    }
    */
    
    @FunctionalInterface
    static public interface StringReader {
        String get(int i);
    }
    
    @FunctionalInterface
    static public interface Decoder<T> {
        T decode(ByteBuffer bb, StringReader sr);
    }
    
    static public class Error extends RuntimeException {
        Error(String msg, Throwable reason) {
            super(msg, reason);
        }
    }

    /*
    static public <K,V> TreeMap<K,V> map(byte[] buf, Decoder<V> decoder, Function<V,K> keyFn) {        
        TreeMap<K,V> map = new TreeMap<>();
        read(buf, null, decoder, (x) -> map.put(keyFn.apply(x), x));
        return map;
    }
    */
    
    static public class Header {
        public final String format;
        public final int rowCount;
        public final int colCount;
        public final int rowSize;
        public final int row0;
        Header(String format, int rowCount, int colCount, int rowSize, int row0) {
            this.format = format;
            this.rowCount = rowCount;
            this.colCount = colCount;
            this.rowSize = rowSize;
            this.row0 = row0;
        }
        public void dump() {
            System.out.println(this);
        }
        @Override
        public String toString() {
            return String.format("Format(%s) Columns(%d) Rows(%d) RowSize(%d) Row0(%d)", format, colCount, rowCount, rowSize, row0);
        }
    }
    
    static public Header header(byte[] buf) {
        String format;        
        try {
            format = new String(buf, 0, 4, StandardCharsets.US_ASCII);   
        } catch (RuntimeException err) {
            throw new Error("Error parsing format", err);
        }
        int version;
        switch (format) {
            case "WDBC": {
                version = 1; 
                break;    
            }
            case "WDB2": {
                version = 2; 
                break;
            }
            default: 
                throw new Error("Unknown format: " + format, null);
        }
        ByteBuffer bb = ByteBuffer.wrap(buf).order(ByteOrder.LITTLE_ENDIAN);
        try {
            int rowCount = bb.getInt(4);
            int colCount = bb.getInt(8);
            int rowSize = bb.getInt(12);
            //int strSize = bb.getInt(16);
            int row0;
            if (version == 2) {
                final int H = 48;
                int id0 = bb.getInt(32);
                int id1 = bb.getInt(36);
                if (id1 != 0) {
                    row0 = H + (1 + id1 - id0) * 6;
                } else {
                    row0 = H;
                }
                //byte[] v = Arrays.copyOfRange(buf, H,  row0);
                //System.out.println(Arrays.toString(v));
            } else {
                row0 = 20;
            }       
            return new Header(format, rowCount, colCount, rowSize, row0);
        } catch (RuntimeException err) {
            throw new Error("Error parsing header", err);
        }
    }
    
    static public <T> void read(byte[] buf, Header hdr, Decoder<T> decoder, Consumer<T> consumer) {
        if (hdr == null) {
            hdr = header(buf);
        }
        final int str0 = hdr.row0 + hdr.rowSize * hdr.rowCount;
        StringReader r = (i) -> {
            int pos = str0 + i;
            if (pos < str0 || pos >= buf.length) {
                throw new Error("String index outside of buffer: " + i, null);
            }
            int end = pos;
            while (buf[end] != 0) {
                end++;
            }
            if (pos == end) {
                return null;
            }
            return new String(buf, pos, end - pos, StandardCharsets.UTF_8);
        };
        ByteBuffer bb = ByteBuffer.wrap(buf).order(ByteOrder.LITTLE_ENDIAN);
        try {            
            for (int i = 0; i < hdr.rowCount; i++) {     
                int pos = hdr.row0 + i * hdr.rowSize;
                bb.limit(pos + hdr.rowSize);
                bb.position(pos);
                consumer.accept(decoder.decode(bb, r));
            }
        } catch (Error err) {
            throw err;
        } catch (RuntimeException err) {
            throw new Error("Error parsing rows", err);
        }
    }
    
    /*
    
    @FunctionalInterface
    static public interface IOFunction<I,O> {
        O read(I in) throws IOException;
    }
    
    static public class DBCException extends IOException {
        DBCException(String msg) { super(msg); }
    }
    
    static private void skipFully(InputStream in, long skip) throws IOException {
        while (skip > 0) {            
            long jump = in.skip(skip);
            if (jump == -1) {
                throw new EOFException();
            }
            skip -= jump;            
        }
    }
    
    static public <T> void read(Path file, Function<ByteBuffer,T> rowFn) throws IOException {
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(Files.newInputStream(file)))) {            
            
            byte[] temp = new byte[4];
            in.readFully(temp);            
            String type = new String(temp, StandardCharsets.US_ASCII);   
            boolean db2 = false;
            switch (type) {
                case "WDBC": break;    
                case "WDB2": db2 = true; break;
                default: throw new DBCException("Unknown format: " + type);
            }
            int rowCount = in.readInt();
            int colCount = in.readInt();
            int rowSize = in.readInt();
            int strSize = in.readInt();
            if (db2) {
                final int headerSize = 48;
                //int tableSize = in.readInt();                    
                //in.readInt(); // tableHash
                //in.readInt(); // build
                // 
                skipFully(in, 20);
                int unk3 = in.readInt();                    
                skipFully(in, 8);
                if (unk3 != 0) {
                    skipFully(in, unk3 * 4 - headerSize);
                    skipFully(in, unk3 * 2 - headerSize * 2);
                }
            }
            byte[] buf = new byte[rowSize];
            ByteBuffer bb = ByteBuffer.wrap(buf);
            for (int i = 0; i < rowCount; i++) {
                in.readFully(buf);
                bb.clear();
                rowFn.apply(bb);                
            }
            
        }
    }
    
    
    static public void read(Path file) throws IOException {
        
        
        try (SeekableByteChannel bc = Files.newByteChannel(file)) {                        
            ByteBuffer header = ByteBuffer.allocate(52);     
            header.limit(20); 
            readExact(bc, header);            
            header.flip();
            byte[] temp = new byte[4];
            header.get(temp);
            String type = new String(temp, StandardCharsets.US_ASCII);   
            int version;
            switch (type) {
                case "WDBC": version = 1; break;    
                case "WDB2": version = 2; break;
                default: throw new DBCException("Unknown format: " + type);
            }
            int rowCount = header.getInt();
            int colCount = header.getInt();
            int rowSize = header.getInt();
            int strSize = header.getInt();
            if (version == 2) {
                int left = 48 - header.limit();
                header.clear();
                header.limit(left);
                readExact(bc, header);
                int unk3 = header.getInt(8);   
                if (unk3 > 0) {
                    bc.position(4 + unk3 * 6);
                }
            }
            long row0 = bc.position();
            
            long str0 = row0 + rowSize * rowCount;
            bc.position(str0);
            Byte
            
            
            
            
        }
    }
    
    static private void readExact(SeekableByteChannel bc, ByteBuffer bb) throws IOException{        
        int need = bb.limit() - bb.position();        
        int read = bc.read(bb);
        if (read == -1) {
            throw new EOFException();
        } else if (read != need) {
            throw new IOException(String.format("Expected %d, Read %d", need, read));
        }
    }
    */
}
