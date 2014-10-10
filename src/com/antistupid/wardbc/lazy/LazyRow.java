package com.antistupid.wardbc.lazy;

abstract public class LazyRow<K> {

    abstract public K getPrimaryKey();
    
    @Override
    public String toString() {
        return LazyDBC.toString(this, true);
    }
    
    public void dump() {
        System.out.println(LazyDBC.toString(this, false));
    }
    
    static public <T extends LazyRow> T dump(T obj) {
        obj.dump();
        return obj;
    }

    
}
