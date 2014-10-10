package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class SpellShapeshiftForm extends LazyRowId {

    static public final String FILE = "SpellShapeshiftForm.dbc";
    
    public int actionBar;
    public String name;
    public int flags;
    public int creatureType;
    public int spellIconId;
    public int swingTime;
    public final int[] displayId = new int[4];
    public final int[] presetSpellId = new int[10]; // this is probably wrong 
           
    
}
