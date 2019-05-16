package com.bittech;

import java.util.ArrayList;
import java.util.List;

public class TestOOMEoor {
    static class OOMObject{

    }
    //在JVM程序启动时，通过参数指定内存
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
