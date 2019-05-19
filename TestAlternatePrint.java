package com.bittech;

class PrintThread implements Runnable{

    private int count = 1;


    @Override
    public void run() {
        while (true){
            synchronized (this){
                notifyAll();
                if(count <= 100){
                    System.out.println(Thread.currentThread().getName()+ " "+count);
                    count++;
                }else {
                    break;
                }

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class TestAlternatePrint {
    public static void main(String[] args) {
        PrintThread printThread = new PrintThread();
        Thread thread1 = new Thread(printThread,"A");
        Thread thread2 = new Thread(printThread,"B");
        thread1.start();
        thread2.start();
    }
}
