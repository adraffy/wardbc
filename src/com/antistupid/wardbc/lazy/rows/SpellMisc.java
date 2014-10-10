package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class SpellMisc extends LazyRowId {

    static public final String FILE = "SpellMisc.db2";
    
    //00:flags
    //01:flags_1
    //02:flags_2
    //03:flags_3
    //04:flags_4
    //05:flags_5
    //06:flags_6
    //07:flags_7
    //08:flags_12694
    //09:flags_8
    //10:unk_2
    //11:flags_15668
    //12:flags_16467
    public final int[] flags = new int[14];
    public int id_cast_time;
    public int id_duration;
    public int id_range;
    public float prj_speed;
    public int id_spell_visual_1;
    public int id_spell_visual_2;    
    public int id_icon;
    public int id_icon_active;
    public int mask_school;    
    public int unk_18379;
    
    
    
}
