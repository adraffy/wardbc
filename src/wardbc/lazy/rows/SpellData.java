package wardbc.lazy.rows;

import wardbc.lazy.LazyRowId;

public class SpellData extends LazyRowId {
    
    static public final String FILE = "Spell.dbc";
    
    public String name;
    public String rank;
    public String desc;
    public String tooltip;
    public int id_rune_cost;	
    public int id_missile;
    public int id_desc_var;
    //public float extra_coeff;
    public int id_scaling;
    public int id_aura_opt;
    public int id_aura_rest;
    public int id_cast_req;
    public int id_categories;
    public int id_class_opts;
    public int id_cooldowns;
    public int id_equip_items;
    public int id_interrupts;
    public int id_levels;
    public int id_reagents; // these swapped places
    public int id_power; // need to check this one
    public int id_shapeshift;
    public int id_tgt_rest;
    public int id_totems;
    public int id_misc;
    

}
