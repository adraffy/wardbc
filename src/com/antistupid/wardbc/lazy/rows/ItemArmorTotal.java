package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class ItemArmorTotal extends LazyRowId {

    static public final String FILE = "ItemArmorTotal.dbc";
    /*
      m_ID; // +0x0, size 0x4, type 0
   m_itemLevel; // +0x4, size 0x4, type 0
   m_cloth; // +0x8, size 0x4, type 3
   m_leather; // +0xC, size 0x4, type 3
   m_mail; // +0x10, size 0x4, type 3
   m_plate; // +0x14, size 0x4, type 3
    */
    
    public int _id;
    public float[] value = new float[4];
    
    
}
