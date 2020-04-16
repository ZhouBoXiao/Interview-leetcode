package _公司笔试._webank._3;


import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            int cnt  = 0;
            Map<Character, Integer> map = new HashMap<>();

            int odd = 0;
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);

            }

            for (char c : s.toCharArray()) {
                if (map.get(c) % 2 != 0) {
                    odd++;
                }
            }

            while (odd > 1) {
                cnt++;
                odd--;
            }


            if (cnt % 2 == 0) {
                System.out.println("Cassidy");
            } else{
                System.out.println("Eleanore");
            }
        }
    }
}
