package com.antistupid.wardbc.lazy;

abstract public class LazyRowId extends LazyRow<Integer> {

    public int id;
    
    @Override
    public Integer getPrimaryKey() {
        return id;
    }
    
}
