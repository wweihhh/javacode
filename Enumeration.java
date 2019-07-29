package com.gitwh;

import java.util.List;
import java.util.Vector;

public class Enumeration {
    public static void main(String[] args) {
       Vector<String> vector = new Vector<>();
       vector.add("a");
       vector.add("b");
       //elements（）取得Enumeration接口对象
       java.util.Enumeration<String> enumeration = vector.elements();
       while (enumeration.hasMoreElements()){
           System.out.println(enumeration.nextElement());
       }
    }
}
