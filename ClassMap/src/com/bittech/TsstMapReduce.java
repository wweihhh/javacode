package com.bittech;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

class Goods{
    private String name;
    private double price;
    private Integer count;

    public Goods(String name, double price, Integer count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
public class TsstMapReduce {
    public static void main(String[] args) throws Exception{
        List<Goods> list = new ArrayList<>();
        list.add(new Goods("mac",20.0,3));
        list.add(new Goods("dior",90.0,9));
        list.add(new Goods("纪梵希",300.0,7));
        list.add(new Goods("M4",90.0,8));
        Double allPrice = list.stream()
                .map(obj -> obj.getCount()*obj.getPrice())
                .reduce((sum,x) -> sum + x)
                .get();
        System.out.println(allPrice);

    }
}
