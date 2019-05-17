package com.bittech;

class Teacher1 implements Cloneable{
    private String name;
    private String subject;

    public Teacher1(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }
    public Teacher1 clone() {
        Teacher1 teacher1 = null;
        try {
            teacher1 = (Teacher1) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return teacher1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

class Student1 implements Cloneable {
    private String name;
    private int age;
    private Teacher1 teacher1;

    public Student1(String name, int age, Teacher1 teacher1) {
        this.name = name;
        this.age = age;
        this.teacher1 = teacher1;
    }

    public Student1 clone() {
        Student1 student1 = null;
        try {
            //实现拷贝处理
            student1 = (Student1) super.clone();
            student1.teacher1 = this.teacher1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return student1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Teacher1 getTeacher1() {
        return teacher1;
    }

    public void setTeacher1(Teacher1 teacher1) {
        this.teacher1 = teacher1;
    }

    //    @Override
//    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", teacher=" + teacher +
//                '}';
//    }
}
public class TestDeepCopy {
    public static void main(String[] args) {
        Teacher1 teacher1 = new Teacher1("offila","java Teacher");
        Student1 student1 = new Student1("liyifeng",18,teacher1);
        Student1 studentClone1 = student1.clone();
        //地址
        System.out.println("student "+student1);
        System.out.println("studentClone "+studentClone1);
        System.out.println("-------------------");
        System.out.println(studentClone1.getName());
        System.out.println(studentClone1.getAge());
        System.out.println(studentClone1.getTeacher1().getName());
        System.out.println(studentClone1.getTeacher1().getSubject());
        System.out.println(teacher1 == studentClone1.getTeacher1());
    }
}

