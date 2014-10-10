package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class SpellCooldown extends LazyRowId {
    
    static public final String FILE = "SpellCooldowns.dbc";
    
    public int id_spell;    
    public int unk_15589_1;
    public int category_cooldown;
    public int cooldown;
    public int gcd_cooldown;

}
