package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class ItemHeader extends LazyRowId {

    static public final String FILE = "Item.db2";
    
    /*
    'id',      ( 'classs', '%2d' ), ( 'subClass', '%2d' ), ( 'unk_3', '%d' ), ( 'material', '%d' ),
          'fileDataId', 'equipId',   'sheath'
    */
    
    public int itemClass;
    public int subClass;
    public int unk_3; // -1...21
    public int material;
    public int equipId; // 0-28
    public int sheath;
    public int fileDataId; //filedata.dbc
    public int wut;
    
    
}
