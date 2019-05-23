package com.bittech.GC;

public class TestFinalize {
    //这里finalize可以作为一个GC Roots 因为是静态的
    private static TestFinalize finalize;

    public void isAlive(){
        if (finalize != null){
            System.out.println("I am Alive:)");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method execute");
        //将finalize与当前的建立联系
        finalize = this;
    }

    public static void main(String[] args) {
        //让GC Roots 指向new TestFinalize()这个对象
        finalize = new TestFinalize();
        //此时这个对象已经不可达了
        finalize = null;
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (finalize != null){
            finalize.isAlive();
        }else {
            System.out.println("I am dead:(");
        }
        //-----------------------------------
        //虽然此时对象所在的类覆写了finalize（），
        // 但因为上面已经调用过，所以此次对象已经彻底死亡
        finalize = null;
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (finalize != null){
            finalize.isAlive();
        }else {
            System.out.println("I am dead:(");
        }
    }
}
