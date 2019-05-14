package com.bittech;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class TestEnumeration {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("hello");
        vector.add("bit");
        vector.add("hello");
        vector.add("java");
        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }
        System.out.println("-----------------");
        for (String str : vector){
            System.out.println(str);
        }
    }
}
