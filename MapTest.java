package com.gitwh;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"hello");
        map.put(2,"world");
        map.put(3,"hello");
        map.put(10,"liyifeng");
        map.put(100,"offila");
        map.put(null,null);
        map.put(1,null);
//        System.out.println(map.get(10));
//        System.out.println(map.get(200));
//        System.out.println(map.get(1));
//        map.remove(2);
//        System.out.println(map.get(2));
        Set<Map.Entry<Integer,String>> entrySet =
                map.entrySet();//将Map变为Set
        Iterator<Map.Entry<Integer,String>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry =
                    iterator.next();
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

    }
}
