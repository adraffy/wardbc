package wardbc.lazy;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Consumer;
import wardbc.DBC;
import wardbc.DBC.Decoder;
import wardbc.DBC.StringReader;

public class LazyDBC {
    
    public final Path dbcDir;
    
    public LazyDBC(Path dbcDir) {
        this.dbcDir = dbcDir;
    }
    
    public Path getFile(Class<? extends LazyRow> cls) {
        return dbcDir.resolve(getFileName(cls));
    }
    
    public void dump(Class<? extends LazyRow> cls) {
        list(cls).forEach(System.out::println);
    }
    
    public <K,V extends LazyRow<K>> TreeMap<K,V> map(Class<? extends V> cls) {  
        Path file = getFile(cls);
        try {
            TreeMap<K,V> map = new TreeMap<>();           
            remap(Files.readAllBytes(file), map, cls);            
            return map;
        } catch (IOException err) {
            throw new RuntimeException("Unable to load " + cls + ": " + file, err);
        }        
    }
        
    public <V extends LazyRow> ArrayList<V> list(Class<? extends V> cls) {
        Path file = getFile(cls);
        try {
            byte[] buf = Files.readAllBytes(file);
            DBC.Header hdr = DBC.header(buf);
            ArrayList<V> list = new ArrayList<>(hdr.rowCount); // aw yiss
            populate(buf, cls, list::add);   
            return list;
        } catch (IOException err) {
            throw new RuntimeException("Unable to load " + cls + ": " + file, err);
        }  
    }
    
    // ---
    
    static private class E {
        final Class<? extends LazyRow> cls;
        final F[] fields;
        final int count;
        final String fileName;
        E(Class<? extends LazyRow> cls, F[] fields, String fileName) {
            this.cls = cls;
            this.fields = fields;
            int n = 0;
            for (F x: fields) {
                n += x.size;
            }
            this.count = n;
            this.fileName = fileName;
        }
    }
    
    static private final HashMap<Class<? extends LazyRow>,E> MAP = new HashMap<>();
    
    static private class F {
        final Field field;
        final FieldType type;
        final int size;
        final boolean hidden;
        F(Field field, FieldType type, int size) {
            this.field = field;
            this.type = type;
            this.size = size;
            hidden = field.getName().endsWith("_hide"); // Kappa!
        }
        /*
        String toString(Object obj) throws IllegalAccessException {
            return type.toString(obj, field);
        }
        */
    }
    
    abstract static private class FieldType {
        abstract void decode(Object obj, Field field, ByteBuffer bb, StringReader sp) throws IllegalAccessException;  
        String toString(Object obj, Field field) throws IllegalAccessException {
            return String.valueOf(field.get(obj));
        }
    }
       
            
    static private final FieldType STRING = new FieldType() {
        @Override
        void decode(Object obj, Field field, ByteBuffer bb, StringReader sp) throws IllegalAccessException {
            field.set(obj, sp.get(bb.getInt()));
        }  
    };
    
    static private final FieldType BYTE = new FieldType() {
        @Override
        void decode(Object obj, Field field, ByteBuffer bb, StringReader sp) throws IllegalAccessException {
            field.set(obj, bb.get());
        }     
    };
    
    static private final FieldType SHORT = new FieldType() {
        @Override
        void decode(Object obj, Field field, ByteBuffer bb, StringReader sp) throws IllegalAccessException {
            field.set(obj, bb.getShort());
        }     
    };
    
    static private final FieldType INT = new FieldType() {
        @Override
        void decode(Object obj, Field field, ByteBuffer bb, StringReader sp) throws IllegalAccessException {
            field.set(obj, bb.getInt());
        }     
    };
    
    static private final FieldType FLOAT = new FieldType() {
        @Override
        void decode(Object obj, Field field, ByteBuffer bb, StringReader sp) throws IllegalAccessException {
            field.set(obj, bb.getFloat());
        }     
    };
    
    static private final FieldType BOOLEAN = new FieldType() {
        @Override
        void decode(Object obj, Field field, ByteBuffer bb, StringReader sp) throws IllegalAccessException {
            field.set(obj, bb.getInt() != 0);
        }     
    };
    
    static private final FieldType STRING_ARRAY = new FieldType() {
        @Override
        void decode(Object obj, Field field, ByteBuffer bb, StringReader sp) throws IllegalAccessException {
            String[] arr = (String[])field.get(obj);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sp.get(bb.getInt());
            }   
        }   
        @Override
        String toString(Object obj, Field field) throws IllegalAccessException {
            return Arrays.toString((String[])field.get(obj));
        } 
    };
    
    static private final FieldType INT_ARRAY = new FieldType() {
        @Override
        void decode(Object obj, Field field, ByteBuffer bb, StringReader sp) throws IllegalAccessException {
            int[] arr = (int[])field.get(obj);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = bb.getInt();
            }   
        }   
        @Override
        String toString(Object obj, Field field) throws IllegalAccessException {
            return Arrays.toString((int[])field.get(obj));
        }   
    };
    
    static private final FieldType FLOAT_ARRAY = new FieldType() {
        @Override
        void decode(Object obj, Field field, ByteBuffer bb, StringReader sp) throws IllegalAccessException {
            float[] arr = (float[])field.get(obj);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = bb.getFloat();
            }   
        }
        @Override
        String toString(Object obj, Field field) throws IllegalAccessException {
            return Arrays.toString((float[])field.get(obj));
        }             
    };    
    
    // note: we are assuming jvm field allocation order
    static private E make(Class<? extends LazyRow> cls0) {        
        ArrayList<F> list0 = new ArrayList<>();
        Object dummy = makeObject(cls0); // we need to allocate a dummy object :(        
        Class cls = cls0;
        String fileName = null;
        do {
            Field[] fields =  cls.getDeclaredFields();
            List<F> list = list0.subList(0, 0);
            for (Field f: fields) {                            
                try {
                    if ((f.getModifiers() & java.lang.reflect.Modifier.STATIC) != 0) {
                        if (cls == cls0 && f.getName().equals("FILE")) {
                            fileName = (String)f.get(null);
                        }
                        continue;
                    }
                    if (f.getName().startsWith("__")) {
                        continue;
                    }
                    Object dummyValue = f.get(dummy);
                    Class type = f.getType();
                    FieldType decoderType;
                    if (type == int.class || type == Integer.class) {
                        decoderType = INT;
                    } else if (type == short.class || type == Short.class) {
                        decoderType = SHORT;
                    } else if (type == byte.class || type == Byte.class) {
                        decoderType = BYTE;
                    } else if (type == float.class || type == Float.class) {
                        decoderType = FLOAT;
                    } else if (type == String.class) {
                        decoderType = STRING;
                    } else if (type == int[].class || type == Integer[].class) {
                        decoderType = INT_ARRAY;
                    } else if (type == float[].class || type == Float[].class) {
                        decoderType = FLOAT_ARRAY;
                    } else if (type == String[].class) {
                        decoderType = STRING_ARRAY;
                    } else if (type == boolean.class) {
                        decoderType = BOOLEAN;
                    } else {
                        System.err.println("Unsupported field: " + f);
                        continue;
                    }
                    int size = type.isArray() ? java.lang.reflect.Array.getLength(dummyValue) : 1;
                    list.add(new F(f, decoderType, size));
                } catch (IllegalAccessException err) {
                    System.err.println("Problem accessing field: " + f);
                    err.printStackTrace();
                }
            }   
            cls = cls.getSuperclass();
        } while (cls != null);
        if (fileName == null) {
            System.err.println(cls0 + " missing FILE");
        }
        return new E(cls0, list0.toArray(new F[list0.size()]), fileName);
    }
    
    static private E get(Class<? extends LazyRow> cls) {
        E temp = MAP.get(cls);
        if (temp == null) {  
            temp = make(cls);
            MAP.put(cls, temp);            
        }
        return temp;
    }
    
    static private <T extends LazyRow> T makeObject(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException|IllegalAccessException err) {
            // could use factory to avoid this cancery bullshit
            throw new RuntimeException("Zero arg constructor failed", err);
        }
    }
    
    // ---
    
    static public String getFileName(Class<? extends LazyRow> cls) {
        return get(cls).fileName;
    }
    
    static public int getFieldCount(Class<? extends LazyRow> cls) {        
        return get(cls).count;
    }
    
    /*
    static public <K,V extends LazyRow<K>> TreeMap<K,V> map(Class<? extends V> cls, Path dir) {  
        try {
            TreeMap<K,V> map = new TreeMap<>();
            remap(Files.readAllBytes(dir.resolve(getFileName(cls))), map, cls);            
            return map;
        } catch (IOException err) {
            throw new RuntimeException("Unable to load " + cls, err);
        }        
    }
    
    static public <V extends LazyRow> ArrayList<V> list(Class<? extends V> cls, Path dir) {
        try {
            byte[] buf = Files.readAllBytes(dir.resolve(getFileName(cls)));
            DBC.Header hdr = DBC.header(buf);
            printHeaderWarning(cls, hdr);
            ArrayList<V> list = new ArrayList<>(hdr.rowCount);
            populate(buf, cls, list::add);   
            return list;
        } catch (IOException err) {
            throw new RuntimeException("Unable to load " + cls, err);
        }         
    }
    */
    
    static public void printHeaderWarning(Class<? extends LazyRow> cls, DBC.Header header) {
        int expect = getFieldCount(cls);
        if (header.colCount != expect) {
            System.err.println(String.format("%s Warning: %s field count mismatch: Expect(%d) %s", LazyDBC.class.getSimpleName(), cls.getName(), expect, header));
        }
    }
    
    static public <T extends LazyRow> void populate(byte[] buf, Class<T> cls, Consumer<T> sink) {
        DBC.Header hdr = DBC.header(buf);
        printHeaderWarning(cls, hdr);
        DBC.read(buf, hdr, getDecoder(cls), sink);
    }
    
    static public <K,V extends LazyRow<K>> void remap(byte[] buf, TreeMap/*fk-yo-type*/ map, Class<? extends LazyRow<K>> cls) {  
        map.clear();
        DBC.Header hdr = DBC.header(buf);
        printHeaderWarning(cls, hdr);
        DBC.read(buf, hdr, getDecoder(cls), (x) -> map.put(x.getPrimaryKey(), x));
    }
    
    static public String toString(LazyRow obj, boolean inline) {
        if (obj == null) {
            return "null";
        }
        E temp = get(obj.getClass());
        StringBuilder sb = new StringBuilder();
        if (inline) {
            for (F f: temp.fields) {
                if (f.hidden) {
                    continue;
                }
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(f.field.getName());
                sb.append("(");
                try {
                    sb.append(f.type.toString(obj, f.field));
                } catch (IllegalAccessException err) {
                    sb.append("?");
                }
                sb.append(")");
            }  
        } else {
            int max = 0;
            for (F f: temp.fields) {
                if (!f.hidden) {
                    max = Math.max(max, f.field.getName().length());
                }
            }
            sb.append(temp.cls.getName());
            String nameFmt = "%" + max + "s"; // Kappa            
            for (F f: temp.fields) {
                if (f.hidden) {
                    continue;
                }
                //if (sb.length() > 0) {
                //    sb.append("\n");
                //}
                sb.append("\n");
                sb.append(String.format(nameFmt, f.field.getName()));                
                sb.append(" = ");
                try {
                    sb.append(f.type.toString(obj, f.field));
                } catch (IllegalAccessException err) {
                    sb.append(err); // shouldn't happen
                }
            }  
        }
        return sb.toString();
    }
    
    static public <T extends LazyRow> Decoder<T> getDecoder(Class<T> cls) {
        E temp = get(cls);
        return (bb, sr) -> {
            T row = makeObject(cls);
            for (F f: temp.fields) {
                try {
                    f.type.decode(row, f.field, bb, sr);
                } catch (IllegalAccessException|RuntimeException err) {
                    throw new RuntimeException("Error decoding field " + f.field, err);
                }
            }
            return row;
        };
    }
}
