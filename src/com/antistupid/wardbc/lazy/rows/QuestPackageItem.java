package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class QuestPackageItem extends LazyRowId {

    static public final String FILE = "QuestPackageItem.db2";
    
    public int packageId;
    public int itemId;
    public int _quantity; // always 1
    public int type; // 0 = explode into item, 1 = item directly, 2 = bag?
    
    
}
