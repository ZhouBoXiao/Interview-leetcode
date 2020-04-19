package _公司笔试._京东._1;

import java.util.*;


public class Main {


    static boolean ok(int[][] panel) {
        Set<Integer> set = new HashSet<>();
        set.add(panel[0][0]);
        set.add(panel[0][1]);
//        set.add(panel[1][0]);
        boolean flag = true;
        for (int i = 1; i < 6; i++) {


            if (flag && !set.contains(panel[i][0])  ) {
                set.add(panel[i][0]);
                flag = false;
            }
            if (flag &&  !set.contains(panel[i][1])) {
                set.add(panel[i][1]);
                flag = false;
            }
            if (!set.contains(panel[i][0]) || !set.contains(panel[i][1])) {
                return false;
            }


        }
        for (int i = 0; i < 6; i+=2) {
            if (panel[i][0] != panel[i+1][0] || panel[i][1] != panel[i+1][1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        while (n-- > 0) {
            int[][] panel = new int[6][2];
            for (int i = 0 ; i < 6; i ++) {
                int t1 = in.nextInt();
                int t2 = in.nextInt();
                panel[i][0] = Math.min(t1,t2); //
                panel[i][1] = Math.max(t1,t2);
            }
            Arrays.sort(panel, (a,b)->{
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            });
            boolean res = ok(panel);
            System.out.println(res ? "POSSIBLE" : "IMPOSSIBLE");
        }
        in.close();
    }
}
/*

2
1345 2584
2584 683
2584 1345
683 1345
683 1345
2584 683
1234 4567
1234 4567
4567 4321
4322 4567
4321 1234
4321 1234
 */
