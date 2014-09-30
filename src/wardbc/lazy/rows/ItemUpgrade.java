package wardbc.lazy.rows;

import wardbc.lazy.LazyRowId;

public class ItemUpgrade extends LazyRowId {

    static public final String FILE = "ItemUpgrade.db2";
    
    public int chainId;
    public int itemLevelDelta;
    public int prevId;
    public int currencyId;
    public int currencyCost;
    
}
