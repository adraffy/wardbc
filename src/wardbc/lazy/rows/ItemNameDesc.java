package wardbc.lazy.rows;

import wardbc.lazy.LazyRowId;

public class ItemNameDesc extends LazyRowId {

    static public final String FILE = "ItemNameDescription.dbc";
    
    // 'id', 'ofs_desc', ( 'flags', '%#.8x' )
    public String name;
    public int flags;
    
}
