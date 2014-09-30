package wardbc.lazy.rows;

import wardbc.lazy.LazyRowId;

public class FileData extends LazyRowId {

    static public final String FILE = "FileData.dbc";
    
    public String name;
    public String path;
    
    public String fileNameWithoutExtension() {
        int pos = name.indexOf('.');
        return pos >= 0 ? name.substring(0, pos) : name;
    }
    
}
