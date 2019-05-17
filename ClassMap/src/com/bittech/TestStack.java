package com.bittech;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("123");
        stack.push("456");
        stack.push("789");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
