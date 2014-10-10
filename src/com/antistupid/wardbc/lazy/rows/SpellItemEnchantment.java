package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class SpellItemEnchantment extends LazyRowId {

     static public final String FILE = "SpellItemEnchantment.dbc";
    
    //SpellItemEnchantment.dbc
    
    /*
     ( 'id', '%4u' ), 'charges', 
          ( 'type_1', '%3u' ), ( 'type_2', '%3u' ), ( 'type_3', '%3u' ), 
          ( 'amount_1', '%4d' ), ( 'amount_2', '%4d' ), ( 'amount_3', '%4d' ),
          ( 'id_property_1', '%6u' ), ( 'id_property_2', '%6u' ), ( 'id_property_3', '%6u' ), 
            'ofs_desc', 'id_aura', ( 'slot', '%2u' ), ( 'id_gem', '%6u' ), 'enchantment_condition', 
          ( 'req_skill', '%4u' ), ( 'req_skill_value', '%3u' ), 'req_player_level', ( 'max_scaling_level', '%3u' ), ( 'min_scaling_level', '%3u' ),
          ( 'id_scaling', '%2d' ), ( 'unk_15464_3', '%2d' ), ( 'coeff_1', '%7.4f' ), ( 'coeff_2', '%7.4f' ), ( 'coeff_3', '%7.4f' ),
    */

    static public final int N = 3;
    
    public int charges;
    public final int[] typeId = new int[N];
    public final int[] value = new int[N];
    public final int[] propId = new int[N];
    public String desc;
    public int auraId;
    public int slot; //32: 1710, 0: 1652, 33: 240, 1: 80, 3: 13, 9: 14
    public int gemId;
    public int enchantCondId;
    public int reqSkill;
    public int reqSkillRank;
    public int minScalingLevel; //reqLevel;
    public int maxScalingLevel;
    public int scalingPerLevel;
    public int scalingId;
    public int unk_15464_3;    
    public final float[] coeff = new float[N];
    
    
}
