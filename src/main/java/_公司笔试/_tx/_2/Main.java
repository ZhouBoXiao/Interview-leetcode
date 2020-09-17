package _公司笔试._tx._2;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/6 20:01
 */

import java.util.*;


public class Main {
    class Node {
        int color;
        int val;
        Node(int x, int y) {color = x; val = y;}
    }

    void solve() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[2 * n];
        String s = sc.next();
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < 2 * n ; i++) {
            a[i] = sc.nextInt();
            list.add(new Node(s.charAt(i) == 'R' ? 0 : 1, a[i]));
        }
        int res = 0;
        for (int i = 0; i < 2 * n; i++) {
            for (int j = i + 1; j < 2 * n; j++) {
                if (list.get(i).color == list.get(j).color && list.get(i).val > list.get(j).val) {
                    for (int k = j; k > i; k--) {
                        swap(list, k, k - 1);
                        res++;
                    }
                    break;
                }
            }
        }
        System.out.println(res);
    }

    void solve2(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        String temp;
        for (int i = 0; i < N; i++) {
            temp = sc.next();
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2)-> !o1.getValue().equals(o2.getValue()) ? o2.getValue() - o1.getValue() : o1.getKey().compareTo(o2.getKey()));
        for (int i = 0; i < K; i++) {
            System.out.println(list.get(i).getKey() + "" + list.get(i).getValue());
        }

        list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2)-> !o1.getValue().equals(o2.getValue()) ? o1.getValue() - o2.getValue() : o1.getKey().compareTo(o2.getKey()));
        for (int i = 0; i < K; i++) {
            System.out.println(list.get(i).getKey() + "" + list.get(i).getValue());
        }
    }

    void swap(List<Node> list, int i, int j) {
        Node temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    void solve3() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        HashSet<Integer> temp;
        int flag = -1, num, len;
        for(int i = 0; i < M; ++i) {
            len = sc.nextInt();
            temp = new HashSet<>();
            for(int j = 0; j < len; ++j) {
                num = sc.nextInt();
                if(num == 0 && flag == -1) {
                    flag = i;
                }
                temp.add(num);
            }
            list.add(temp);
        }
        sc.close();
        if (flag == -1) System.out.println(0);
        else {
            LinkedList<Integer> queue = new LinkedList<>();

            HashSet<Integer> vis = new HashSet<>();
            temp = list.remove(flag);
            for (Integer integer : temp) {
                queue.addLast(integer);
                vis.add(integer);
            }
            int size = 0;

            while (!queue.isEmpty()) {
                size = queue.size();
                for (int i = 0; i < size; i++) {
                    num = queue.removeLast();
                    for (HashSet<Integer> set : list) {
                        if (set.contains(num)) {
                            for (Integer in : set) {
                                if (!vis.contains(in)) {
                                    queue.addLast(in);
                                    vis.add(in);
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(vis.size());
        }
    }


    public static void main(String[] args) {
        new Main().solve();
    }
}
/*

50 5
2 1 2
5 10 11 12 13 14
2 0 1
2 49 2
4 6 7 2 10


0 1 2 6 7 10 11 12 13 14 49
 */