package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class ItemBonus extends LazyRowId {

    static public final String FILE = "ItemBonus.db2";
    
    //'id', '%6u' ), ( 'nodeId', '%4u' ), ( 'type', '%2u' ), ( 'val1', '%6d' ), ( 'val2', '%6d' ), ( 'index', '%2u' )
    public int nodeId;
    public int type;
    public int val1;
    public int val2;
    public int index;

    
}
