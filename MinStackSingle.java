package com.bittech.oj;

import java.util.Stack;

//隐式双栈    放一个数据放一个当前最小值
public class MinStackSingle {
    private Stack<Integer> stack = new Stack<>();
    public MinStackSingle(){

    }
    public void push(int x) {
       if (stack.isEmpty()){
           stack.push(x);
           stack.push(x);
       }else {
           int temp = stack.peek();
           if (x < temp){
               stack.push(x);
           }else {
               stack.push(temp);
           }
       }
    }

    public void pop() {
       stack.pop();
       stack.pop();

    }

    public int top() {
        int temp = stack.pop();
        int result = stack.peek();
        stack.push(temp);
        return result;
    }

    public int getMin() {
        return stack.peek();
    }
}