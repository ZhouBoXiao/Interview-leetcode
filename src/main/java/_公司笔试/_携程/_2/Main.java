package _公司笔试._携程._2;

import java.util.*;

/**
 * 求给定两点的所有路径的题，dfs解决，注意读入数据的时候要建立地名和编号的双向映射
 */
public class Main {
    static  List<List<String>> result = new ArrayList<>();

    static void dfs(Map<String, List<String>> graph, String cur, Map<String, Boolean> visit, String end, List<String> next) {
        if (cur.equals(end)) {
            result.add(new ArrayList<>(next));
            return;
        }
        for (int i = 0 ; i < graph.get(cur).size(); i++) {
            String temp = graph.get(cur).get(i);
            if (visit.containsKey(temp)) {
                if (visit.get(temp))
                    continue;
            }
            next.add(temp);
            visit.put(temp, true);
            dfs(graph, temp, visit,end, next );
            visit.put(temp, false);
            next.remove(next.size() - 1);
        }
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String inputStr = cin.nextLine().trim();
        if (!inputStr.contains("A") || !inputStr.contains("B")) {
            System.out.println("EMPTY");
            return;
        }
        String[] strs = inputStr.split(";");

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Boolean> visit = new HashMap<>();

        for (String s : strs) {

            String[] ss = s.split(",");
            ss[0] = ss[0].substring(1);
            ss[1] = ss[1].substring(0,ss[1].length() - 1);
            if (graph.containsKey(String.valueOf(s.charAt(1)))) {
                graph.get(ss[0]).add(ss[1]);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(ss[1]);
                graph.put(ss[0],tmp);
            }
        }


        List<String> next = new ArrayList<>();
        next.add("A");
        visit.put("A", true);
        dfs(graph, "A", visit,"B", next );
        Collections.sort(result, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                if (o1.size() == o2.size()) {
                    for (String s1 : o1) {
                        for (String s2 : o2) {
                            if (s1.compareTo(s2) != 0) {
                                return s1.compareTo(s2);
                            }
                        }
                    }
                }
                return o1.size() - o2.size();
            }
        });
        if (result != null && result.size() > 0) {
            System.out.println(result);
        } else {
            System.out.println("EMPTY");
        }
    }
}
/*

(A,B);(A,C);(C,B);(C,D);(D,B);

(A,B);(A,C);(C,A);(C,B);(C,D);(D,B);(B,D);(D,C);
 */