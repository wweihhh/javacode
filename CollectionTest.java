package com.gitwh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("h");
        list.add("e");
        list.add("l");
        list.add("l");
        list.add("o");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            if (str.equals("h")){
                list.remove(0);
            }
            System.out.println(str);
        }
    }
}
