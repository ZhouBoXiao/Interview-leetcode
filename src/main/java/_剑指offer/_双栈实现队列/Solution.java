package _剑指offer._双栈实现队列;

import java.util.*;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty() ) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            return -1;
            //throw new Exception("");
        }
    }
    public int peek() {
        if (stack2.isEmpty() ) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (!stack2.isEmpty()) {
            return stack2.peek();
        } else {
            return -1;
            //throw new Exception("");
        }
    }

    public static void main(String[] args) {

    }
}
