package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class SpellRange extends LazyRowId {

    /*
     'id',       ( 'min_range', '%7.1f' ), ( 'min_range_2', '%5.1f' ), ( 'max_range', '%7.1f' ), ( 'max_range_2', '%5.1f' ),
          'id_range',   'unk_6',                  'unk_7'
    */
    
    public float min_range;
    public float min_range_2;
    public float max_range;
    public float max_range_2;
    public int id_range;
    public int unk_6;
    public int unk_7;
    
}
