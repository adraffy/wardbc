package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class SpellEffectScaling extends LazyRowId {

    static public final String FILE = "SpellEffectScaling.dbc";
    
    public float average;
    public float delta;
    public float bonus;
    public int id_effect;
    
    @Override
    public Integer getPrimaryKey() {
        return id_effect; // this is better :p
    }
    
}
