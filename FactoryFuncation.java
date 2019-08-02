package www.bite.reflect;

interface Food{
    public void eat();
}

class Rice implements Food{

    @Override
    public void eat() {
        System.out.println("eat rice");
    }
}
class Cake implements Food{

    @Override
    public void eat() {
        System.out.println("eat cake");
    }
}

interface FoodFactory{
    public Food createFood();
}
class FactoryA implements FoodFactory{

    @Override
    public Food createFood() {
        return new Rice();
    }
}
class FactoryB implements FoodFactory{

    @Override
    public Food createFood() {
        return new Cake();
    }
}

public class FactoryFuncation {
    public static void main(String[] args) {
        FoodFactory foodFactory = new FactoryA();
        Food rice = foodFactory.createFood();
        rice.eat();
    }
}
