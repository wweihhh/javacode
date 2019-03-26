package www.bite.java;

import org.omg.PortableServer.THREAD_POLICY_ID;
import sun.dc.pr.PRError;

import java.util.concurrent.Callable;

enum Color{
    RED("红色"),BLUE("蓝色",6),GREEN("绿色"),YELLO();
    private String title;
    private int a;
    private Color(){
    }
    private Color(String title){
        this.title = title;
    }
    private Color(String title,int a){
        this.title = title;
        this.a = a;
    }
    public String toString(){
        return this.title+"-"+this.a;
    }

}


interface IColor{
    String getColor();
}

enum ColorImpl implements IColor{
    RED("红"),BLUE("蓝"),YELLO("黄");
    private String title;
    private ColorImpl(String title){
        this.title = title;
    }
    public String toString(){
        return this.title;
    }
    @Override
    public String getColor() {
        return this.title;
    }
}
enum Sex{
    MALE("MAN"),FEMALE("WOMEN");
    private String title;
    private Sex(String title){
        this.title = title;
    }
    public String toString(){
        return this.title;
    }
}
class Person{
    private String name;
    private int age;
    private Sex sex;

    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public String toStrong(){
        return "[name = " + name + ",age = " + age + ",sex = "+ sex + "]";
    }
}

public class testdemo {
    public static void main(String[] args) {
//        Color[] colors = Color.values();
//       for (Color k : colors){
//           System.out.println(k.ordinal()+"=" + k.name());
//       }
        System.out.println(Color.BLUE);
        System.out.println(Color.RED);//第二个参数默认值为0
        System.out.println(Color.YELLO);

        IColor icolor1 = ColorImpl.RED;
        System.out.println(icolor1.toString());
        System.out.println(icolor1.getColor());

        Person per = new Person("zhangsan",14,Sex.MALE);
        System.out.println(per.toStrong());
    }
}
