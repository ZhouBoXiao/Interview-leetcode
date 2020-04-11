package _美团笔试._5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] nums = new int[n];
        String num = scanner.next();
        for (int i = 0;i < n; i++) {
            nums[i] = Integer.valueOf(num.charAt(i)+ "");

        }
        for (int i = 0; i < m; i++) {
           String operation = scanner.next();
           if (operation.charAt(0) == 'q') {
               query(nums);
           } else {
               int x = Integer.parseInt(scanner.next());
               int y = Integer.parseInt(scanner.next());
               c(nums, x -1 , y -1);
           }

        }
    }

    private static void c(int[] nums, int x, int y) {
        for (int i = x; i <= y; i++) {
            nums[i] = 1 - nums[i];
        }

    }

    private static void query(int[] nums) {
        int len = 0;
        int maxLen = 0;
        int endIndex =-1;
        for (int i = nums.length -1; i > 0; i--) {
            if (nums[i] >= nums[i-1]) {
                len++;
                if (len > maxLen) {
                    endIndex = i;
                    maxLen = len;
                }
            }
            else {
                len = 0;
            }

        }
        if (endIndex > 0) {
            if (nums[endIndex] >= nums[endIndex-1]) {
                maxLen++;
            }
        }
        System.out.println(maxLen);
    }



}
