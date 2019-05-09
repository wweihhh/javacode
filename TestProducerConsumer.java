package com.bittech;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Goods{
    private int maxCount;
    private String name;
    private int count;

    public Goods(int maxCount) {
        this.maxCount = maxCount;
    }

    //生产者锁
    private Lock lock = new ReentrantLock();
    //生产者消费者等待队列
    private Condition proCondition = lock.newCondition();
    private Condition consumCondition = lock.newCondition();

    //生产者方法
    public void setGoods(String name) {
        lock.lock();
        try {
            while (count == maxCount) {
                //商品达到最大值，生产者线程等待
                System.out.println(Thread.currentThread().getName() +
                        "生产已达最大值，生产者等待消费者消费商品");
                try {
                    proCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.name = name;
            count++;
            System.out.println(Thread.currentThread().getName()+
            "生产"+toString());
            //唤醒消费者，消费
            consumCondition.signalAll();
        }finally {
            lock.unlock();
        }

    }
    //消费者方法
    public void getGoods(){
        lock.lock();
        try{
            while (count == 0){
                System.out.println(Thread.currentThread().getName()+
                "商品卖完了，消费者等待生产者生产商品");
                try {
                    consumCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count--;
            System.out.println(Thread.currentThread().getName()+
            "消费"+toString());
            proCondition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}

class Producer implements Runnable{
    private Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true){
            this.goods.setGoods("生产Dior999");
        }
    }
}

class Consumer implements Runnable{
    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true){
            this.goods.getGoods();
        }
    }
}

public class TestProducerConsumer {
    public static void main(String[] args) {
        Goods goods = new Goods(50);
        Producer producer = new Producer(goods);
        Consumer consumer = new Consumer(goods);
        List<Thread> list = new ArrayList<>();
        //5个生产者
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(producer,"producer"+i);
            list.add(thread);
        }
        //10个消费者
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(consumer,"consumer"+i);
            list.add(thread);
        }
        for (Thread thread:list){
            thread.start();
        }
    }
}
