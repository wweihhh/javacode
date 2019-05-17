package com.bittech;

class Teacher{
    private String name;
    private String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
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

class Student implements Cloneable {
    private String name;
    private int age;
    private Teacher teacher;

    public Student(String name, int age, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }

    public Student clone() {
        Student student = null;
        try {
            //实现拷贝处理
            student = (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return student;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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
public class TestShallowCopy {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("offila","java Teacher");
        Student student = new Student("liyifeng",18,teacher);
        Student studentClone = student.clone();
        //地址
        System.out.println("student "+student);
        System.out.println("studentClone "+studentClone);
        System.out.println("-------------------");
        System.out.println(studentClone.getName());
        System.out.println(studentClone.getAge());
        System.out.println(studentClone.getTeacher().getName());
        System.out.println(studentClone.getTeacher().getSubject());
        System.out.println(teacher == studentClone.getTeacher());
    }
}
