package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class ItemPriceBase extends LazyRowId {

    static public final String FILE = "ItemPriceBase.dbc";
    
    public int _id; //duplicate of id
    public float a;
    public float b;
    
}
