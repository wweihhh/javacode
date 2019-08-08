package com.gitwh;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;



class MyClassLoader extends ClassLoader{

    @Override
    @Deprecated
    //findClass方法的作用就是根据类名加载.Class字节码
    public Class<?> findClass(String className) throws ClassNotFoundException {
        byte[] data = null;
        try {
            data = this.loadClassData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.defineClass(data,0,data.length);//将字节码转换为Class
    }

    public byte[] loadClassData() throws Exception{
        InputStream in = new FileInputStream(
                "C:\\Users\\xptyxx20170501A\\Desktop\\Test.class");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] data = new byte[20];
        int temp = 0;
        while ((temp = in.read(data))!=-1){
            bos.write(data,0,temp);
        }
        byte[] result = bos.toByteArray();
        in.close();
        bos.close();
        return result;
    }

}
public class MyClassLoaderTest {
    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> cls = myClassLoader.findClass("com.gitwh.Test");
        System.out.println(cls.getClassLoader());
        System.out.println(cls.getClassLoader().getParent());
        System.out.println(cls.getClassLoader().getParent().getParent());
        System.out.println(cls.getClassLoader().getParent().getParent().getParent());

    }
}
