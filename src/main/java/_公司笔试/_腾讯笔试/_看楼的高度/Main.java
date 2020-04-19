package _公司笔试._腾讯笔试._看楼的高度;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for(int i = 0 ; i < len ; i++){
            arr[i] = sc.nextInt();
        }
        // stack中要保存的是 能看见的楼的 index
        int[] rightLook = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            rightLook[i] = stack.size();
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);
        }
        stack.clear();
        int total = 0;
        for (int j = 0; j < len; j++) {
            total = rightLook[j] + 1 + stack.size();
            while (!stack.isEmpty() && arr[j] >= arr[stack.peek()]) {
                stack.pop();
            }
            if (j == len -1) {
                System.out.println(total);
            } else {
                System.out.print(total + " ");
            }
            stack.push(j);
        }
    }
}
