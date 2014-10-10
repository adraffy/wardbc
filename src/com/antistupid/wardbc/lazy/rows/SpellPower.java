package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class SpellPower extends LazyRowId {

    static public final String FILE = "SpellPower.db2";
    
    public int id_spell;
    public int unk_15589_1; // dunno {0, 1, 2, 3}
    public int type_power;
    public int int_cost;
    public int int_cost_per_second;
    public int unk_1;
    public int unk_18505;
    public int unk_2;
    public int id_display; // was removed, now back
    public float float_cost; // can be mana %
    public float float_cost_per_second;
    public int aura_id;
    public float unk_15589_2;
    
}
