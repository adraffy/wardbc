package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class ItemArmorQuality extends LazyRowId {
    
    static public final String FILE = "ItemArmorQuality.dbc";
    
    public final float[] value = new float[7];
    public int _id;
    
    /*
    FloatField("poor"),
		FloatField("common"),
		FloatField("uncommon"),
		FloatField("rare"),
		FloatField("epic"),
		FloatField("legendary"),
		FloatField("artifact"),
    */
    
    
    /*
    
    m[any][0] = 0.9
    m[any][1] = 0.95
    m[any][2] = 1.0
    m[444;;][3;;7] = 1
    m[;;20][[3;;7] = { 1.2693603, 1.5387205, 1.5387205, 1.5387205}
    
    */
    
    
}
