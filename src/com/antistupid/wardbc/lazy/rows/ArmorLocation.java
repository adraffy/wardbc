package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class ArmorLocation extends LazyRowId {

    static public final String FILE = "ArmorLocation.dbc";
    /*
       m_ID; // +0x0, size 0x4, type 0
   m_clothmodifier; // +0x4, size 0x4, type 3
   m_leathermodifier; // +0x8, size 0x4, type 3
   m_chainmodifier; // +0xC, size 0x4, type 3
   m_platemodifier; // +0x10, size 0x4, type 3
   m_modifier; // +0x14, size 0x4, type 3
    */
    
    public final float[] armorMod = new float[4];
    public float mod;
    
}
