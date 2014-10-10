package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class ItemBonusTreeNode extends LazyRowId {

    static public final String FILE = "ItemBonusTreeNode.db2";
    
    // ( 'id', '%4u' ), ( 'treeId', '%4u' ), ( 'qualifier', '%3u' ), ( 'childId', '%4u' ), ( 'nodeId', '%4u' )
    
    public int treeId;
    public int qualifier; //  17 = slag mines
    public int childId; // only one of
    public int nodeId;   // these is set
    
}
