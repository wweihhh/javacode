package com.bittech.queue;

public class ArrayQueue<E> implements Queue<E>{
    private Object[] obj;
    private int head;
    private int tial;

    public ArrayQueue(int maxSize) {
        obj = new Object[maxSize];
    }

    @Override
    public void enQueue(E e) {
        if (tial == obj.length){
            if (head == 0){
                System.err.println("队列已满");
                return;
            }else {
                for (int i = head;i < tial;i++){
                    obj[i-head] = obj[head];
                }
            }
            tial = tial-head;
            head = 0;
        }
        obj[tial++] = e;
    }

    @Override
    public E deQueue() {
        if (isEmpty()){
            System.err.println("队列为空");
            return null;
        }
        return (E) obj[head++];
    }

    @Override
    public E peek() {
        if (isEmpty()){
            System.err.println("队列为空");
            return null;
        }
        return (E) obj[head];
    }

    @Override
    public int getSize() {
        return tial - head;
    }

    @Override
    public boolean isEmpty() {
        return tial - head == 0;
    }
}
