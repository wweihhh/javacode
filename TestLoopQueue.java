package com.bittech.Leetcode;

import com.bittech.queue.Queue;

class MyCircularQueue {
    private Object[] elementData;
    private int head;
    private int tail;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        elementData = new Object[k + 1];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()){
            System.out.println("队列已满");
            return false;
        }
        elementData[tail] = value;
        tail = (tail + 1)%elementData.length;
        size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()){
            System.out.println("队列为空");
            return false;
        }
        Object result = elementData[head];
        elementData[head] = null;
        head = (head+1)%elementData.length;
        size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()){
            return -1;
        }
        Object result = elementData[head];
        return (int) result;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()){
            return -1;
        }
        int i = (tail-1+ elementData.length)%elementData.length;
        return (int) elementData[i];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return tail - head == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if ((tail+1)%elementData.length == head){
            return true;
        }
        return false;
    }
}

public class TestLoopQueue {
    public static void main(String[] args) {

    }
}
