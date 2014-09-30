package wardbc.lazy.rows;

import wardbc.lazy.LazyRowId;

public class RandPropPoints extends LazyRowId {

    static public final String FILE = "RandPropPoints.dbc";
    
    static public final int N = 5;
    
    public final int[] epic = new int[N];
    public final int[] superior = new int[N];
    public final int[] uncommon = new int[N];
    
}
