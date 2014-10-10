package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class SpellProcsPerMinuteMod extends LazyRowId {

    static public final String FILE = "SpellProcsPerMinuteMod.dbc";
    
    public int unk_1; // 1-7
    public int specId;
    public float coeff; // additive i think
    public int ppmId;
    
}
