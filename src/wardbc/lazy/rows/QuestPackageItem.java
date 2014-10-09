package wardbc.lazy.rows;

import wardbc.lazy.LazyRowId;

public class QuestPackageItem extends LazyRowId {

    static public final String FILE = "QuestPackageItem.db2";
    
    public int packageId;
    public int itemId;
    public int quantity_hide; // always 1
    public int type; // 0 = explode into item, 1 = item directly, 2 = bag?
    
    
}
