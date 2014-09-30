package wardbc.lazy.rows;

import wardbc.lazy.LazyRowId;

public class ItemPriceBase extends LazyRowId {

    static public final String FILE = "ItemPriceBase.dbc";
    
    public int id_hide; //duplicate of id
    public float a;
    public float b;
    
}
