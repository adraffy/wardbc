package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class ItemModifiedAppearance extends LazyRowId {
    
    static public final String FILE = "ItemModifiedAppearance.db2";
    
    public int itemId;
    public int unk_1; // small digit [1-8]
    public int appearId;
    public int unk_2; // displayInfo?
    public int index; // guess?

}
