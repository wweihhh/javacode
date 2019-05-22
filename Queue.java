package com.bittech.queue;

public interface Queue<E> {
    void enQueue(E e);
    E deQueue();
    E peek();
    int getSize();
    boolean isEmpty();
}
