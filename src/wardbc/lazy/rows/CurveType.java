package wardbc.lazy.rows;

import wardbc.lazy.LazyRowId;

public class CurveType extends LazyRowId {
    
    static public final String FILE = "Curve.db2";

    // when 0, level -> ilvl?
    // when 2, curve goes 0-1 // some kind of curve type
    public int type; 
    public int unk_hide; // always 2... 
    
}
