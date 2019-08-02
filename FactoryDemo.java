package www.bite.reflect;

import java.util.function.IntFunction;

interface IFruit{
    public void eat();
}
class Apple implements IFruit{

    @Override
    public void eat() {
        System.out.println("eat apple!");
    }
}
class FruitFactory{
    private FruitFactory(){}
    public static IFruit getInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //反射实现简单工厂模式
        //这时不再需要在工厂类中修改代码，而是根据调用方法时传入类名
        //再通过反射取得该类实例 这就动态的获得了不同的具体类对象
        IFruit iFruit;
        iFruit = (IFruit) Class.forName(className).newInstance();
        return iFruit;
        //        if ("apple".equals(className)){
//            return new Apple();
//        }
//        return null;

    }

}
public class FactoryDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        IFruit fruit = FruitFactory.getInstance("www.bite.reflect.Apple" );
        fruit.eat();
    }
}
