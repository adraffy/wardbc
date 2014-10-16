package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

abstract public class ItemDamage extends LazyRowId {

    static public final int N = 7;
    
    public float[] value = new float[N];
    public int _id; // same as id
    
    static public class TwoHand extends ItemDamage {
        static public final String FILE = "ItemDamageTwoHand.dbc";
    }
      
    static public class TwoHandCaster extends ItemDamage {
        static public final String FILE = "ItemDamageTwoHandCaster.dbc";
    }
    
    static public class OneHand extends ItemDamage {
        static public final String FILE = "ItemDamageOneHand.dbc";
    }
      
    static public class OneHandCaster extends ItemDamage {
        static public final String FILE = "ItemDamageOneHandCaster.dbc";
    }
    
    static public class Wand extends ItemDamage {
        static public final String FILE = "ItemDamageWand.dbc";
    }
      
    static public class Ranged extends ItemDamage {
        static public final String FILE = "ItemDamageRanged.dbc";
    }
    
    
    
}


