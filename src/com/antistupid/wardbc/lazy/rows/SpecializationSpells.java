package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class SpecializationSpells extends LazyRowId {

    static public final String FILE = "SpecializationSpells.dbc";
   
    public int specId;
    public final int[] spellIds = new int[3];
    
}
