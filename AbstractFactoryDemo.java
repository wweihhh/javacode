package www.bite.reflect;

interface Mobile{
    public void buyMobiel();
}
class Honor implements Mobile {

    @Override
    public void buyMobiel() {
        System.out.println("buy honor");
    }
}
class Vivo implements Mobile{

    @Override
    public void buyMobiel() {
        System.out.println("buy vivo");
    }
}
interface PC{
    public void buyPc();
}
class Hp implements PC{

    @Override
    public void buyPc() {
        System.out.println("buy hp");
    }
}
class Dell implements PC{

    @Override
    public void buyPc() {
        System.out.println("buy dell");
    }
}
interface Factorys{
    Mobile MobileProduce();
    PC PCProduce();
}
class Factory1 implements Factorys{

    @Override
    public Mobile MobileProduce() {
        return new Honor();
    }

    @Override
    public PC PCProduce() {
        return new Hp();
    }
}
class Factory2 implements Factorys{

    @Override
    public Mobile MobileProduce() {
        return new Vivo();
    }

    @Override
    public PC PCProduce() {
        return new Dell();
    }
}
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        //比如这个工厂时一个独立的公司的工厂 而这个公司有好多不同产品
        //此时这段代码中的工厂接口中的不同的方法就像是一个公司的不同部门的工厂
        //而不同的工厂类之间就像是不同的公司   每个公司都有他们的部门  就可以生产不同的产品
        Factorys factory1 = new Factory1();
        Mobile mobile = factory1.MobileProduce();
        mobile.buyMobiel();
        factory1.PCProduce().buyPc();


        Factorys factory2 = new Factory2();
        PC pc = factory2.PCProduce();
        pc.buyPc();
    }
}
