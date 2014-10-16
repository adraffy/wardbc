package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class CurveType extends LazyRowId {
    
    static public final String FILE = "Curve.db2";

    // when 0, level -> ilvl?
    // when 2, curve goes 0-1 // some kind of curve type
    public int type; 
    public int _unk; // always 2... 
    
}
