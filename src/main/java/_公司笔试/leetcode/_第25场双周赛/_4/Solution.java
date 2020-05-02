package _公司笔试.leetcode._第25场双周赛._4;

import java.util.*;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/2 22:31
 */
public class Solution {
    static int MOD = 1000000007;
    int cnt = 0;
    public int numberWays(List<List<Integer>> hats) {

        int n = hats.size();
//        boolean[] vis1 = new boolean[41];
//        boolean[] vis2 = new boolean[41];
        Queue<Integer> q1 = new LinkedList<>();
        Set<Integer> vis1 = new HashSet<>();
        Set<Integer> vis2 = new HashSet<>();
        Queue<Integer> q2 = new LinkedList<>();

//        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < hats.get(0).size(); i++) {
            vis1.add(hats.get(0).get(i));
            q1.add(1);

            for (int j = n - 1; j < hats.get(n - 1).size(); j++) {
                vis1.add(hats.get(n-1).get(i));
                q2.add(n-2);
                while (!q1.isEmpty() && !q2.isEmpty()) {

                    if (q1.size() > q2.size()) {
                        Queue<Integer> tmp = q1;
                        q1 = q2;
                        q2 = tmp;
                        Set<Integer> t = vis1;
                        vis1 = vis2;
                        vis2 = t;
                    }
                    int size = q1.size();
                    while (size-- > 0) {
                        int cur = q1.poll();
                        for (int k = 0; k < hats.get(cur).size(); k++) {
                            int temp = hats.get(cur).get(k);
                            if (vis1.contains(temp)) {
                                continue;
                            }
                            if (vis2.contains(temp)) {
                                cnt++;
                                if (cnt > MOD) {
                                    cnt %= MOD;
                                }
                            } else {
                                q1.offer(cur);
                                vis1.add(temp);
                            }

                        }

                    }

                }


                vis1.remove(hats.get(n-1).get(i));


            }
            vis1.remove(hats.get(0).get(i));
//            vis1[hats.get(0).get(i)] = false;
        }
        return cnt;
    }

//    void dfs(List<List<Integer>> hats, boolean[] vis, int cur, int n ) {
//
//        if (cur == n) {
//            cnt++;
//            if (cnt > MOD) {
//                cnt %= MOD;
//            }
//            return;
//        }
//
//        for (int i = 0; i < hats.get(cur).size(); i++) {
//            int temp = hats.get(cur).get(i);
//            if (vis[temp]) continue;
//            vis[temp] = true;
//            dfs(hats, vis, cur+1, n);
//            vis[temp] = false;
//        }
//    }
    public static void main(String[] args) {
        List<List<Integer>> hats = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(3);
            tmp.add(4);
        }
        System.out.println(new Solution());
    }
}
