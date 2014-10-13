package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class SpellIcon extends LazyRowId {
    
    static public final String FILE = "SpellIcon.dbc";

    public String iconPath;
    
    public String fileName() {
        if (iconPath == null) {
            return null;
        }
        int pos = iconPath.lastIndexOf('\\');
        return (pos >= 0 ? iconPath.substring(pos + 1) : iconPath).toLowerCase();        
    }
    
}
