package com.bittech;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class TestProperties {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\xptyxx20170501A\\Desktop\\DBConfig.properties");
        Properties properties = new Properties();
        properties.setProperty("user","offila");
        properties.setProperty("passward","123456");
        properties.store(new FileOutputStream(file),"user and passward");

        Properties properties1 = new Properties();
        properties1.load(new FileInputStream(file));
        System.out.println(properties.getProperty("user"));
        System.out.println(properties.getProperty("passward"));


    }
}
