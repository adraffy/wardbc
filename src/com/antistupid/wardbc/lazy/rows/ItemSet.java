package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class ItemSet extends LazyRowId {

    static public final String FILE = "ItemSet.dbc";
    /*
    'id', 'ofs_name', 
          'id_item_1', 'id_item_2', 'id_item_3', 'id_item_4', 'id_item_5',
          'id_item_6', 'id_item_7', 'id_item_8', 'id_item_9', 'id_item_10',
          'id_item_11', 'id_item_12', 'id_item_13', 'id_item_14', 'id_item_15',
          'id_item_16', 'id_item_17',
          'id_spell_1', 'id_spell_2', 'id_spell_3', 'id_spell_4',
          'id_spell_5', 'id_spell_6', 'id_spell_7', 'id_spell_8',
          'n_items_1', 'n_items_2', 'n_items_3', 'n_items_4',
          'n_items_5', 'n_items_6', 'n_items_7', 'n_items_8',
          'id_req_skill', 'val_req_skill'
    */
    
    public String name;
    public final int[] item_ids = new int[17];    
    public int req_skill;
    public int req_skill_level;
    
}
