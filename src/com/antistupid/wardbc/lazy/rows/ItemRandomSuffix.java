package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class ItemRandomSuffix extends LazyRowId {

    static public final String FILE = "ItemRandomSuffix.dbc";
    
    /*
    ( 'id','%4u' ),   'ofs_name_sfx',   'ofs_name_int',
          ( 'id_property_1', '%5u' ),  ( 'id_property_2',  '%5u' ), ( 'id_property_3', '%5u' ),  ( 'id_property_4', '%5u' ),  ( 'id_property_5', '%5u' ),
          ( 'property_pct_1', '%5u' ), ( 'property_pct_2', '%5u' ), ( 'property_pct_3', '%5u' ), ( 'property_pct_4', '%5u' ), ( 'property_pct_5', '%5u' )
    */
    
    public String name;
    public String desc;
    static final int N = 5;
    public final int[] propId = new int[N];
    public final int[] value = new int[N];
    
}
