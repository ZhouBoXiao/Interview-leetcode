package _剑指offer._栈的压入弹出序列;

import java.util.*;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack();
        int j = 0;
        for (int elem : pushed) {
            stack.push(elem);
            while (j < popped.length && !stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }

        }
        return j == popped.length;
    }

    public static void main(String[] args) {

    }
}
