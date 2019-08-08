package com.gitwh;

import com.sun.org.apache.xerces.internal.parsers.CachingParserPool;

public class SafeSingleton {
    private volatile static SafeSingleton intance = null;
    private SafeSingleton(){}
    public static SafeSingleton getIntance(){
        if (intance == null){
            synchronized (SafeSingleton.class){
                if (intance == null){
                    intance = new SafeSingleton();
                }
            }
        }
        return intance;
    }
}
