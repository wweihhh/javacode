package com.bittech;

import java.util.Set;
import java.util.TreeSet;

class Student implements Comparable<Student>{
    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {

        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //自定义Student如何比较大小
    @Override
    public int compareTo(Student o) {
        if (this.age > o.age){
            return 1;
        }else if (this.age < o.age){
            return -1;
        }else {
            return this.name.compareTo(o.name);
        }
     }
}


public class TestTreeSet {
    public static void main(String[] args) {
        Set<Student> set = new TreeSet<>();
        set.add(new Student("liyifeng",18));
        set.add(new Student("offila",17));
        System.out.println(set);

    }
}
