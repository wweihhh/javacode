package com.gitwh;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        ListIterator<String> listIterator =
                list.listIterator();
        while (listIterator.hasNext()){
            System.out.print(listIterator.next()+" ");
        }
        System.out.println();
        while (listIterator.hasPrevious()){
            System.out.print(listIterator.previous()+" ");
        }
    }
}
