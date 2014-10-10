package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class SpellReagents extends LazyRowId {

    static public final String FILE = "SpellReagents.db2";
    
    static public final int N = 8;
    
    public int[] itemId = new int[N];
    public int[] amount = new int[N];
    
    public int unk_1; // 752, 944, 995, 766, 824, 697
    public int unk_2; // 0, 1, 20, 100, 500
    
}
