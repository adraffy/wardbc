package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class ItemXBonusTree extends LazyRowId {
    
    static public final String FILE = "ItemXBonusTree.db2";

    //ItemXBonusTree.db2
    // ( 'id', '%6u' ), ( 'id_item', '%6u' ), ( 'id_tree', '%4u' )

    public int itemId;
    public int treeId;
    
}
