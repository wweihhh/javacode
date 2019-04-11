package www.bite.reflect;


import org.omg.CORBA.OBJ_ADAPTER;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Optional;

interface ISubject{
    void eat(String name,int count);
}

class RealSubject implements ISubject{

    @Override
    public void eat(String name, int count) {
        System.out.println("eat"+count+"" + "两"+name);
    }
}
class ProxySubject implements InvocationHandler{
    private Object object;
    //将真实接口与代理类绑定 返回绑定好的代理类对象
    public Object bind(RealSubject realObject){
        this.object = realObject;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),this);
    }
//proxy 代理类对象  method 真实业务方法  args 方法参数  返回值 真实接口对象
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.before();
        Object obj = method.invoke(this.object,args);
        this.affer();
        return  obj;
    }
    public void before(){
        System.out.println("before handle");
    }

    public void affer(){
        System.out.println("affer handle");
    }
}
public class TeatDemo {
    public static void main(String[] args) throws Exception{
        ISubject subject =(ISubject) new ProxySubject().bind(new RealSubject());
        subject.eat("meat",30);
    }
}
