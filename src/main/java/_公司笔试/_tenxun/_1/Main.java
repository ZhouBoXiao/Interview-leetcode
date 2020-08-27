package _公司笔试._tenxun._1;
/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/8/23 19:59
 */


import java.util.*;
class Node {
    int val;
    Node next;
    Node(int x) {
        val = x;
    }
}
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 1; i <= n; i++) a[i] = scanner.nextInt();
        for(int i = 1; i <= n; i++)if(i != k) System.out.printf("%d ", a[i]);
        System.out.println();
    }
}


class Main1 {

}
