package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class SpellClassOptions extends LazyRowId {

    static public final String FILE = "SpellClassOptions.db2";
    
    // 'id', 'modal_next_spell', ( 'spell_family_flags_1', '%#.8x' ), ( 'spell_family_flags_2', '%#.8x' ), ( 'spell_family_flags_3', '%#.8x' ), ( 'spell_family_flags_4', '%#.8x' ), 'spell_family_name', 'ofs_desc'
    
    public int nextSpellId;
    public final int[] flags = new int[4];
    public int familyName;
    
}
