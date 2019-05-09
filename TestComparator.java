package com.bittech;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Work{
    private String name;
    private Integer age;

    public Work(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Work{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
//Work类的比较器
class AscAgeComparator implements Comparator<Work>{

    @Override
    public int compare(Work o1, Work o2) {
        return o1.getAge()-o2.getAge();

    }
}
class DesAgeComparator implements Comparator<Work>{

    @Override
    public int compare(Work o1, Work o2) {
        return o2.getAge()-o1.getAge();

    }
}
public class TestComparator {
    public static void main(String[] args) {
        //在TreeSet构造方法中传入一个Comparator的对象
//        Set<Work> set = new TreeSet<>(new AscAgeComparator());
        Set<Work> set = new TreeSet<>(new DesAgeComparator());

        set.add(new Work("liyifeng",19));
        set.add(new Work("offila",18));
        System.out.println(set);

    }
}
