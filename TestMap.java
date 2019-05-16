package com.bittech;

import java.util.*;

public class TestMap {
    public static void main(String[] args) {
//        Map<Integer,String> map = new HashMap<>();
        Map<Integer,String> map = new Hashtable<>();

        map.put(1,"hello");
        //当Kay值重复再次put变为相应value的更新操作。
        map.put(1,"liyifeng");
        map.put(2,"hello");
        map.put(3,"offila");
        map.put(null,null);
        map.put(null,null);
        map.put(4,"null");
//        System.out.println(map.get(1));
//        System.out.println(map.get(3));
//        System.out.println(map.get(99));
        //取得所有Key值
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
      for (Integer i: keySet){
          System.out.println(map.get(i));
      }

    }
}
