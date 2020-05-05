package _公司笔试.leetcode._第187场周赛;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/3 10:31
 */
public class Solution {
    public String destCity(List<List<String>> paths) {

//        Queue<String> q1 = new LinkedList<>();
//        q1.add(paths.get(0).get(0));
        Queue<String> q2 = new LinkedList<>();
        boolean[] vis = new boolean[paths.size()];
        q2.add(paths.get(0).get(1));
        int cnt = 0;
        String res = null;
        vis[0] = true;
        while (!q2.isEmpty()) {
            String s = q2.poll();
            cnt++;
            for (int i = 0; i < paths.size(); i ++) {
                if (vis[i]) continue;
                List<String> path = paths.get(i);
                if (s.equals(path.get(0))) {
                    q2.add(path.get(1));
                    vis[i] = true;
                }
            }
            res = s;
        }

//        while (!q2.isEmpty()) {
//            String s = q2.poll();
//            cnt++;
//            for (List<String> path: paths) {
//                if (s.equals(path.get(0))) {
//                    q2.add(path.get(0));
//                }
//
//            }
//        }
        return res;
    }

    public static void main(String[] args) {

    }

}
