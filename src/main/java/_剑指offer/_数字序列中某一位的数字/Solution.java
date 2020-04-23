package _剑指offer._数字序列中某一位的数字;

public class Solution {
    public int findNthDigit(int n) {
        if (n <= 9) return n;
        n-=9;
        long count = 90, digit = 2;
        while (n > count * digit) {
            n -= count * digit;
            count *= 10;
            digit++;
        }

        long temp  = 1;
        for (int i = 1; i <= digit - 1; i++)
            temp *= 10;
        long num = temp +  n / digit;
        if (n % digit == 0) {
            num--;
            return (int) (num % 10);
        } else {
            for (int i =0; i < (digit - n % digit); i++) {
                num/=10;
            }
            return (int) (num%10);
        }

    }

    public static void main(String[] args) {
        new Solution().findNthDigit(1000000000);
    }
}
