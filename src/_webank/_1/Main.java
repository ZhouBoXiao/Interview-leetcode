package _webank._1;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int t = m % n;
        int res = 0;
        if (t == 0) {
            System.out.println(0);
            return;
        } else {
            while (m % n != 0) {

                int sum2 = (n- m % n) * b ;  //买礼物
                int temp = n, sum1 = 0;
                while (m % temp != 0) {
                    sum1 += a;
                    temp--;
                }
                if (sum1 < sum2) {
                    n--;
                    res += a;
                } else {
                    m++;
                    res += b;
                }
            }
        }
        System.out.println(res);
    }

}
