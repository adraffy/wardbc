package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class SpellItemEnchantmentCondition extends LazyRowId {

    static public final String FILE = "SpellItemEnchantmentCondition.dbc";
    
    /*
2 	gemColor[5] 	Byte 		
7 	LT_Operand[5] 	Integer 	
12 	comparator[5] 	Byte 	
17 	compareColor[5] 	Byte 	
22 	value[5] 	Integer 	
27 	Logic[5] 	Byte
    */
    
    static public final int N = 5;
    
    //Format(WDBC) Columns(31) Rows(65) RowSize(72) Row0(20)
    //72 - 4 = 68 -> 30
    
    // this wrong
    public final byte[] gemColor = new byte[N];
    public final int[] operand = new int[N];
    public final byte[] compare = new byte[N];
    public final byte[] compareColor = new byte[N];
    public final int[] value = new int[N];
    public final byte[] logic = new byte[N];
    
}
