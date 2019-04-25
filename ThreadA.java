package com.thread.bite;

class MyThread implements Runnable{
    private String title;
    public MyThread(String title){
        this.title = title;
    }
    @Override
    public void run() {
        for(int i = 0;i < 5;i++){
            System.out.println(this.title+" i = "+i);
        }
    }
}
public class ThreadA {
    public static void main(String[] args) {
//       MyThread mythread1 = new MyThread("thread1");
//       MyThread mythread2 = new MyThread("thread2");
//       MyThread mythread3= new MyThread("thread3");
//       new Thread(mythread1).start();
//       new Thread(mythread2).start();
//       new Thread(mythread3).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("offila");
            }
        }).start();
    }
}
