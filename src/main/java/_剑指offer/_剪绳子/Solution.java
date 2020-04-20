package _剑指offer._剪绳子;

public class Solution {

    public int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int sum = 1;
        while (n >= 3 && n != 4) {
            n-=3;
            sum*=3;
        }

        while (n >= 2) {
            n-=2;
            sum*=2;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().cuttingRope(3));
    }
}
