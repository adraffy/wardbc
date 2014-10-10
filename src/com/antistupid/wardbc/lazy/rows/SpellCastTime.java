package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class SpellCastTime extends LazyRowId {

    static public final String FILE = "SpellCastTimes.dbc";
    
    /*'SpellCastTime.dbc' : [
          'id', ( 'cast_time', '%5d' ), ( 'cast_time_per_level', '%d' ), ( 'min_cast_time', '%5d' )*/
    
    public int cast_time;
    public int cast_time_per_level;
    public int min_cast_time;
       
}
