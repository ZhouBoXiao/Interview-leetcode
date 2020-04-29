package _公司笔试._招行._2;


import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[2*n];
        int[] map = new int[2*n];


        for (int i = 0 ; i <2* n; i ++) {
            nums[i]= scanner.nextInt();
            map[nums[i]] = i;
        }
        int cnt = 0 ;
        for (int i = 0 ; i < nums.length - 1; i+=2) {
            if (nums[i] % 2 == 0) {
                if (nums[i + 1] != nums[i] + 1) {
                    int j = map[nums[i] + 1];
                    map[nums[i] + 1] = i + 1;
                    map[nums[i + 1]] = j;
                    swap(nums, j, i + 1);
                    cnt++;
                }
            } else {
                if (nums[i + 1] != nums[i] - 1) {
                    int j = map[nums[i] - 1];
                    map[nums[i] - 1] = i + 1;
                    map[nums[i + 1]] = j;
                    swap(nums, j, i + 1);
                    cnt++;
                }

            }
        }

        System.out.println(cnt);
    }
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
/*
4
1 2 0 7 5 6 4 3
5
0 1 2 3 4 5 6 7 8 9
4
7 0 5 4 3 2 6 1

 */
