package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class ItemDisplayInfo extends LazyRowId {

    static public final String FILE = "ItemDisplayInfo.dbc";
    
    public int leftModelId;
    public int rightModelId;
    public int leftModelTexture;
    public int rightModelTexture;
    public String icon1;
    public String icon2;
    
}
