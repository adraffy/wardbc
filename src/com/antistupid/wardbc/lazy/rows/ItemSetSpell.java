package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class ItemSetSpell extends LazyRowId {

    static public final String FILE = "ItemSetSpell.dbc";
    
    public int itemSetId;
    public int spellId;
    public int reqItemCount;
    public int reqSpec;

}
