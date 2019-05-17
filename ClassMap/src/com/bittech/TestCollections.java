package com.bittech;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollections {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"a","B","A","b","d","C","D","c");
        //排序
        Collections.sort(list);
        for (String str:list){
            System.out.print(str);
        }
        System.out.println();
        //反转
        Collections.reverse(list);
        for (String str:list){
            System.out.print(str);
        }

    }
}
