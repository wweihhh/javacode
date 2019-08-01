package com.gitwh;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface ISubject{
    public void eat(int num,String msg);
}

class RealImpl implements ISubject{

    @Override
    public void eat(int num,String msg) {
        System.out.println("I want to buy "+ num + msg);
    }
}

class ProxySubject implements InvocationHandler{
    private Object target;

    public ProxySubject(){ }

    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);//此时的this是真实类的对象
    }

    public void preHandle(){
        System.out.println("before buy");
    }

    public void afterHandle() {
        System.out.println("after buy");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.preHandle();
        Object obj = method.invoke(this.target,args);
        this.afterHandle();
        return obj;
    }
}
public class JDKProxyDemo {
    public static void main(String[] args) {

        ISubject subject = (ISubject) new ProxySubject().bind(new RealImpl());

        subject.eat(3,"apples");
        
    }
}
