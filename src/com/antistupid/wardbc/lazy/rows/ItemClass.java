package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class ItemClass extends LazyRowId {
    
    static public final String FILE = "ItmeClass.dbc";
    
    //ItemClass.dbc    
    //    ( 'id', '%3d' ), 'unk_1', 'unk_2', 'unk_3', 'ofs_name'

    public boolean weapon;
    public float flags; // no idea what this shit is, some kind of wearable bit?
    public String name;
    
}
