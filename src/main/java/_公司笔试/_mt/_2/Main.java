package _公司笔试._mt._2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        int left = 0, right = n - 1;
        int res = 0;
        while (left < right) {
            boolean flag = false;
            for (int i = right; i > left; i--) {
                if (list.get(i).equals(list.get(i-1))) {
                    list.set(i-1, list.get(i)+1);
                    list.remove(i);
                    res++;
                    flag= true;
                    break;

                }
            }
            right = list.size() - 1;
            if (!flag) break;

//            for (int i = left; i < right; i++) {
//                if (list.get(i).equals(list.get(i+1))) {
//                    list.set(i+1, list.get(i)+1);
//                    list.remove(i);
//                    res++;
//                    break;
//                }
//            }
//            left = 0;
        }
        System.out.println(res);
    }
}
