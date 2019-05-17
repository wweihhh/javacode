package com.bittech;

import com.sun.xml.internal.ws.wsdl.parser.MemberSubmissionAddressingWSDLParserExtension;
import org.omg.CORBA.INTERNAL;

import java.util.*;

public class TestMapIterator {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"liyifeng");
        map.put(2,"offila");
        map.put(3,"hello");
        //Map->Set
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        //取得Set迭代器
        Iterator<Map.Entry<Integer,String>> iterator = set.iterator();
        //3.迭代输出
        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
}
