package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class SpellScaling extends LazyRowId {

    /*
      'id',                      ( 'cast_min', '%5d' ),           ( 'cast_max', '%5d' ),       ( 'cast_div', '%2u' ),     ( 'id_class', '%2d' ),
        ( 'c_scaling', '%13.10f' ),  ( 'c_scaling_threshold', '%2u' ), ( 'max_scaling_level', '%2u' ),               'unk_15464_2'
          
    */
    
    static public final String FILE = "SpellScaling.dbc";
    
    public int cast_min;
    public int cast_max;
    public int cast_div;
    public int scalingId; //id_class; // IntegerField("class_index"), # (index * 100) + charLevel => gtSpellScaling
    public float c_scaling;
    public float c_scaling_threshold;
    public int max_scaling_level;
    public int unk_15464_2;
    
}
