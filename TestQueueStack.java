package com.bittech.queue;

/*
* 用队列实现栈*/
import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> myQueue1;
    private Queue<Integer> myQueue2;

    /** Initialize your data structure here. */
    public MyStack() {
        myQueue1 = new LinkedList<>();
        myQueue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (myQueue1.isEmpty()){
            myQueue2.add(x);
        }else {
            myQueue1.add(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (myQueue1.isEmpty()){
            int len = myQueue2.size();
            for (int i = 0; i < len-1; i++) {
                myQueue1.add(myQueue2.poll());
            }
            int result = myQueue2.poll();
            return result;
        }
        else {
            int len = myQueue1.size();
            for (int i = 0; i < len-1; i++) {
                myQueue2.add(myQueue1.poll());
            }
            int result = myQueue1.poll();
            return result;
        }
    }

    /** Get the top element. */
    public int top() {
        if (myQueue1.isEmpty()){
            int len = myQueue2.size();
            for (int i = 0; i < len-1; i++) {
                myQueue1.add(myQueue2.poll());
            }
            int result = myQueue2.poll();
            myQueue1.add(result);
            return result;
        }
        else {
            int len = myQueue1.size();
            for (int i = 0; i < len-1; i++) {
                myQueue2.add(myQueue1.poll());
            }
            int result = myQueue1.poll();
            myQueue2.add(result);
            return result;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return myQueue1.isEmpty()&&myQueue2.isEmpty();
    }
}
public class TestQueueStack {
    public static void main(String[] args) {

    }
}
