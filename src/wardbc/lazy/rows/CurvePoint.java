package wardbc.lazy.rows;

import wardbc.lazy.LazyRowId;

public class CurvePoint extends LazyRowId {
    
    static public final String FILE = "CurvePoint.db2";
    
    public int curveId;
    public int index;
    public float lower;
    public float upper;

}

