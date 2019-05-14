package com.bittech;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.*;

public class TestIterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("bit");
        list.add("hello");
        list.add("java");


        //取得ArrayList的迭代器
//       Iterator<String> iterator1 = list.iterator();
        ListIterator<String> iterator = list.listIterator();
//        while (iterator1.hasNext()){
//            System.out.println(iterator1.next());
//        }
       while (iterator.hasNext()){
           System.out.println(iterator.next());
       }
        System.out.println("-------------------------------");
        while (iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }
    }
}
