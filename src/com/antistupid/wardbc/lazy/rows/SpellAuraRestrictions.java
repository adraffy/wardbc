package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class SpellAuraRestrictions extends LazyRowId {

    static public final String FILE = "SpellAuraRestrictions.db2";
    
    /*
    1	 ID                      Integer	
    2	 CasterAuraState	 Integer	
    3	 TargetAuraState	 Integer	
    4	 CasterAuraStateNot	 Integer	
    5	 TargetAuraStateNot	 Integer	
    6	 CasterAuraSpell	 Integer	
    7	 TargetAuraSpell	 Integer	
    8	 ExcludeCasterAuraSpell	 Integer	
    9	 ExcludeTargetAuraSpell	 Integer
    */
    
    public int casterState;
    public int targetState;
    public int casterStateNot;
    public int targetStateNot;
    public int casterSpellId;
    public int targetSpellId;
    public int excludeCasterSpellId;
    public int excludeTargetSpellId;
     
}
