package com.thread.bite;


class MyThreadC implements Runnable{

    @Override
    public void run() {
//        for(int i= 0;i<5;i++){
//            System.out.println("当前线程："+Thread.currentThread().getName()+" i = "+i);
//        }
        System.out.println("当前线程："+Thread.currentThread().getName());
    }
}
public class ThreadC {
    public static void main(String[] args) {
//        MyThreadC mythread = new MyThreadC();
//        Thread thread = new Thread(mythread);
//        thread.start();
//        thread.setName("liyifeng");
//        new Thread(mythread,"offila").start();

        MyThreadC mt = new MyThreadC();
        mt.run();
        new Thread(mt).start();

    }
}
