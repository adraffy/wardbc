package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class SpellDispelType extends LazyRowId {

    static public final String FILE = "SpellDispelType.dbc";
    /*
    Column	Field 			Type 		Notes 
1 	ID 			Integer 	
2-18 	sRefName 		String + Loc
19 	mask 	 	 	 	Added in 3.2.
20 	immunityPossible  	Boolean 	Should type be shown on spell tooltips 
21 	internalName 		String 	
    */
}
