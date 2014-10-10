package com.antistupid.wardbc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public class Tally {

    static public <K,V> void dump(Map<?,V> c, Function<V,K> k) { dump(c.values().stream().map(k)); } // so lazy...      
    static public <K,V> void dump(Collection<V> c, Function<V,K> k) { dump(c.stream().map(k)); }       

    static public <T> void dump(Stream<T> s) {
        Map<T,Integer> map = map(s);
        int num = 0;
        for (Integer x: map.values()) {
            num += x;
        }        
        System.out.println(String.format("Tally: Unique(%d) Total(%d)", map.size(), num));
        /*
        Iterator<Entry<K,Integer>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            for (int i = 0; i < 5 && iter.hasNext(); i++) {
                Entry<K,Integer> e = iter.next();
                System.out.print(String.format("%10s: %-10s", e.getKey(), e.getValue()));
            }
            System.out.println();
        }
        */
        if (!map.isEmpty()) {
            int max = map.keySet().stream().mapToInt((x) -> x.toString().length()).max().getAsInt(); // kappa
            String fmt = "%" + max + "s: %s";
            map.forEach((k, v) -> System.out.println(String.format(fmt, k, v)));
        }
    }
    
    static public <T> Map<T,Integer> map(Stream<T> s) {
        class X { int num; }
        HashMap<T,X> map = new HashMap<>();        
        s.forEach((x) -> {
            X temp = map.get(x);
            if (temp == null) {
                temp = new X();
                map.put(x, temp);
            }
            temp.num++;            
        });
        HashMap<T,Integer> ret = new HashMap<>();
        map.forEach((k, x) -> ret.put(k, x.num));
        return ret;        
    }
    
}
