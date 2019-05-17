package com.bittech;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class TestStream {
    public static void main(String[] args) {
        List<Integer> list  = new ArrayList<>();
        Collections.addAll(list,1,3,5,6,8,9);
        list.forEach(System.out::print);
        System.out.println();
        //取得Stream对象
        Stream<Integer> stream = list.stream();
        //数据过滤，统计集合中所有能被2整除的元素的个数
        System.out.println(stream.filter(e -> e % 2 == 0).count());

        Stream<Integer> stream1 = list.stream();
        System.out.println(stream1.max(Integer::compareTo).get());



    }
}
