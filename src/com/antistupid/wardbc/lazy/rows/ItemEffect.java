package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class ItemEffect extends LazyRowId {
    
    static public final String FILE = "ItemEffect.db2";

    //'id', 'id_item', 'index', ( 'id_spell', '%6u' ), 'trigger_type', ( 'cooldown_category', '%6d' ), ( 'cooldown_category_duration', '%6d' ), ( 'cooldown_group', '%6d' ), ( 'cooldown_group_duration', '%6d' )
    
    public int itemId;
    public int index;
    public int spellId;
    public int triggerType;
    public int cooldownCategory;
    public int cooldownCategoryDuration;
    public int cooldownGroup;
    public int cooldownGroupDuration;
    
}
