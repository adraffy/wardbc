package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class ItemExtendedCost extends LazyRowId {

    static public final String FILE = "ItemExtendedCost.db2";

    /*
    enum ItemExtendedCostFlags
    {
    ITEM_EXTENDED_COST_FLAG_UNK = 0x01, // guild related
    ITEM_EXTENDED_COST_FLAG_SEASON_IN_INDEX_0 = 0x02, // currency requirements under these indexes require season count
    ITEM_EXTENDED_COST_FLAG_SEASON_IN_INDEX_1 = 0x04,
    ITEM_EXTENDED_COST_FLAG_SEASON_IN_INDEX_2 = 0x08,
    ITEM_EXTENDED_COST_FLAG_SEASON_IN_INDEX_3 = 0x10,
    ITEM_EXTENDED_COST_FLAG_SEASON_IN_INDEX_4 = 0x20,
    };
    https://github.com/cmangos/mangos-cata/blob/dadacb852b12dea7103141e2ff01ed54e843a30e/src/game/DB2Structure.h#L63

    ExtendedCostId,int,int,reqarenaslot,reqitem[1],reqitem[2],reqitem[3],reqitem[4],reqitem[5],reqitemcount[1],reqitemcount[2],reqitemcount[3],reqitemcount[4],reqitemcount[5],reqpersonalarenarating,int,reqcur[1],reqcur[2],reqcur[3],reqcur[4],reqcur[5],reqcurrcount[1],reqcurrcount[2],reqcurrcount[3],reqcurrcount[4],reqcurrcount[5],int,int,flags,int,int
    */
    
    static public final int N = 5;
    
    public int unk_1;
    public int unk_2;
    public int reqArena;
    public final int[] reqItem = new int[N];
    public final int[] reqCount = new int[N];
    public int reqPersonal;
    public int unk_3;
    public final int[] reqCur = new int[N];
    public final int[] reqCurCount = new int[N];
    public int unk_4;
    public int unk_5;
    public int unk_6;
    public int unk_7;
    
}
