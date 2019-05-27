package com.bittech.queue;


import java.util.Stack;

class MyQueue {
    private Stack<Integer> myQueue1;
    private Stack<Integer> myQueue2;



    /** Initialize your data structure here. */
    public MyQueue() {
       myQueue1 = new Stack<>();
       myQueue2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        myQueue1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (myQueue1.isEmpty() && myQueue2.isEmpty()){
            throw new RuntimeException("队列为空");
        }if (myQueue2.isEmpty()){
            while (!myQueue1.isEmpty()){
                myQueue2.push(myQueue1.pop());
            }
        }

        return myQueue2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (myQueue1.isEmpty() && myQueue2.isEmpty()){
            throw new RuntimeException("队列为空");
        }if (myQueue2.isEmpty()){
            while (!myQueue1.isEmpty()){
                myQueue2.push(myQueue1.pop());
            }
        }
        return myQueue2.peek();
    }


    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (myQueue1.isEmpty()&&myQueue2.isEmpty()){
            return true;
        }
        return false;
    }
}

public class TestStackQueue {
    public static void main(String[] args) {
        //test do
    }
}
