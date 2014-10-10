package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class CharBaseInfo extends LazyRowId {
    
    static public final String FILE = "CharBaseInfo.dbc";
    //id = raceId
    //public int classMask;
    //public short a;
    //public short b;
    public byte raceId;
    public byte classId;
//public int raceMask;

    /*
    @Override
    public Object getPrimaryKey() {
        return (a << 16) + b;
    }
    */
    
}
