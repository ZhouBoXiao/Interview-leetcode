package _公司笔试._alibaba._1;
import java.util.*;

public class Main {
    long MOD = 1000000007;

    long p(long k) {
        long base = 2;
        long ans = 1;
        while (k > 0) {
            if (k%2 == 0) {
                ans = ans*base % MOD;
            }
            base = base * base % MOD;

            k >>= 1;
        }
        return ans;

    }

    void solution() {

        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        System.out.println(n * p(n-1) % MOD);

    }
    public static void main(String[] args) {
        new Main().solution();
    }
}