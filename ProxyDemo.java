package com.gitwh;

interface Buy {
    void buyMac();
    void buyGivenchy();
}
class Real implements Buy{

    @Override
    public void buyMac() {
        System.out.println("buy a mac");
    }

    @Override
    public void buyGivenchy() {
        System.out.println("buy a givenchy");
    }
}

class ProxyClass implements Buy{
    private Buy buy;
    public ProxyClass(Buy buy){
        this.buy = buy;
    }
    @Override
    public void buyMac() {
        System.out.println("买");
        this.buy.buyMac();
    }

    @Override
    public void buyGivenchy() {
        System.out.println("买");
        this.buy.buyGivenchy();
    }
}
public class ProxyDemo {
    public static void main(String[] args) {
        Buy buy = new ProxyClass(new Real());
        buy.buyMac();
        buy.buyGivenchy();
    }
}
