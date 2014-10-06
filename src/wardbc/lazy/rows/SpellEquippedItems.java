package wardbc.lazy.rows;

import wardbc.lazy.LazyRowId;

public class SpellEquippedItems extends LazyRowId {
    
    static public final String FILE = "SpellEquippedItems.dbc";
    
    //public int[] wut = new int[5];

    public int spellId; // ?
    public int alwaysZero_hide; // int alwaysZero_hide;
    public int itemClass; // 2 == weapon, 4 == armor, 15 = mount
    public int equipMask;
    public int weaponOrArmorMask;
    
    
}
