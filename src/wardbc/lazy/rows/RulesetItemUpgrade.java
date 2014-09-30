package wardbc.lazy.rows;

import wardbc.lazy.LazyRowId;

public class RulesetItemUpgrade extends LazyRowId {

    static public final String FILE = "RulesetItemUpgrade.db2";
    
    // ( 'id', '%5u' ), 'upgrade_level', ( 'id_upgrade_base', '%5u' ), ( 'id_item', '%5u' )
    
    public int upgradeIndex;
    public int upgradeId;
    public int itemId;
    
}
