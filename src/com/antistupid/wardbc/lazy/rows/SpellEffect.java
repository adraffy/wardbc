package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class SpellEffect extends LazyRowId {
    
    static public final String FILE = "SpellEffect.dbc";
    
    public int unk_15589_1;
    public int type;
    public float multiple_value;
    public int subType;
    public int amplitude;
    public int base_value;
    public float coefficient;
    public float dmg_multiplier;
    public int chain_target;	
    public int die_sides;
    public int item_type;	
    public int mechanic;
    public int misc_value;
    public int misc_value_2;
    public float points_per_combo_points;
    public int id_radius;	
    public int id_radius_max;	
    public float real_ppm;
    public final int[] class_mask = new int[4];
    public int trigger_spell;
    public float unk_15589_2;
    public int implicit_target_1;	
    public int implicit_target_2;	
    public int id_spell;
    public int index;
    public int unk_14040;
    public float ap_coefficient;
    
    
    /*
    The interesting parts in this table are effect: school damage, base value: 39, dice base value: 1 and a die sides: 1.
    What this means is that it does damage (effect: school damage). To be more precise it does 39 damage(base value). And it roles a 1 sides die(die sides) which has a base value of 1.
    Since the die is only one sided the roll will always be 1. This is added to the 39base damage for a total of 40. Notice that this 40 is the damage the enchant is reporting when you look it up on say
    */
    
}
