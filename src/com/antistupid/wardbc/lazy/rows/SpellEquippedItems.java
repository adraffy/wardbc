package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class SpellEquippedItems extends LazyRowId {
    
    static public final String FILE = "SpellEquippedItems.dbc";
    
    //public int[] wut = new int[5];

    public int spellId; // ?
    public int _unk; // alwaysZero
    public int itemClass; // 2 == weapon, 4 == armor, 15 = mount
    public int equipMask;
    public int weaponOrArmorMask;
    
    
}
