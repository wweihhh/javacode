package com.thread.bite;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
//class MyThreadB extends Thread{
//    private int ticket = 10;
//
//    @Override
//    public void run(){
//        while (ticket > 0){
//            System.out.println("剩余"+--this.ticket+"张");
//        }
//    }
//}

//class MyThreadB implements Runnable{
//    private int ticket = 5;
//    private String title ;
//    public MyThreadB(){
//    }
//    public MyThreadB(String title){
//        this.title = title;
//    }



class MyThreadB implements Callable<String> {
    private int ticket = 10;
    @Override
    public String call() throws Exception{
        while(ticket > 0){
            System.out.println("spare ticket "+--this.ticket);
    }
        return "empty!";
}


//    @Override
//    public void run() {
//        while (ticket > 0){
//            System.out.println("spare ticket"+--this.ticket);
//        }
//
//    }
}
public class ThreadB {
    public static void main(String[] args) {
//        new MyThreadB().start();
//        new MyThreadB().start();
//        new MyThreadB().start();

//多线程实现卖票：资源共享
//        MyThreadB mythreadb = new MyThreadB();
//        new Thread(mythreadb).start();
//        new Thread(mythreadb).start();
//        new Thread(mythreadb).start();


//        MyThreadB mythreadb1 = new MyThreadB("thread1");
//        MyThreadB mythreadb2 = new MyThreadB("thread2");
//        MyThreadB mythreadb3 = new MyThreadB("thread3");
//        new Thread(mythreadb1).start();
//        new Thread(mythreadb2).start();
//        new Thread(mythreadb3).start();

        Callable<String> callable = new MyThreadB();
        FutureTask<String> task = new FutureTask<>(callable);
        Thread thread = new Thread(task);
        thread.start();



    }
}
