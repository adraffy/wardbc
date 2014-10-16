package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

abstract public class GameTable extends LazyRowId {

    static public final int N = 123;
    
    public float value;
    
    static public class ChanceToMeleeCrit extends GameTable {            
        static public final String FILE = "gtChanceToMeleeCrit.dbc"; 
    }
    static public class ChanceToMeleeCritBase extends GameTable {            
        static public final String FILE = "gtChanceToMeleeCritBase.dbc"; 
    }
    static public class ChanceToSpellCrit extends GameTable {            
        static public final String FILE = "gtChanceToSpellCrit.dbc"; 
    }
    static public class ChanceToSpellCritBase extends GameTable {            
        static public final String FILE = "gtChanceToSpellCritBase.dbc"; 
    }
    static public class CombatRatings extends GameTable {            
        static public final String FILE = "gtCombatRatings.dbc"; 
    }
    static public class OCTClassCombatRatingScalar extends GameTable {            
        static public final String FILE = "gtOCTClassCombatRatingScalar.dbc"; 
    }
    static public class RegenMPPerSpt extends GameTable {            
        static public final String FILE = "gtRegenMPPerSpt.dbc"; 
    }
    static public class SpellScaling extends GameTable {            
        static public final String FILE = "gtSpellScaling.dbc"; 
    }
    static public class OCTBaseMPByClass extends GameTable {            
        static public final String FILE = "gtOCTBaseMPByClass.dbc"; 
    }
    static public class OCTBaseHPByClass extends GameTable {            
        static public final String FILE = "gtOCTBaseHPByClass.dbc"; // dead, all zero
    } 
    static public class OCTHpPerStamina extends GameTable {            
        static public final String FILE = "gtOCTHpPerStamina.dbc"; 
    } 
    static public class ItemSocketCostPerLevel extends GameTable {            
        static public final String FILE = "gtItemSocketCostPerLevel.dbc"; 
    } 
    static public class ArmorMitigationByLvl extends GameTable {            
        static public final String FILE = "gtArmorMitigationByLvl.dbc"; 
    } 

}
