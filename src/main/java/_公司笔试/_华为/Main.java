package _公司笔试._华为;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String[] strs = s.split(",");
        if (strs.length < 1) {
            System.out.println("error.001");
            return ;
        }
        Map<String, Integer> map = new TreeMap<String, Integer>((a,b)-> {
            int min = Math.min(a.length(), b.length());
            for (int i = 0 ; i < min; i++) {
                if (a.charAt(i) < b.charAt(i)) {
                    return 1;
                } else if (a.charAt(i) > b.charAt(i)) {
                    return -1;
                }
            }
            if (a.length() < b.length()) return 1;
            if (a.length() > b.length()) return -1;
            return 0;
        });

        for (int i = 0; i < strs.length; i++) {
            if (!valid(strs[i])) {
                System.out.println("error.001");
                return ;
            } else {
                map.put(strs[i], map.getOrDefault(strs[i], 0 ) + 1);
            }
        }
        int max = 0;
        String temp = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (value >= max) {
                max = value;
                temp = key;
            }
        }

        //排序。将Map转为list，然后进行sort
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        System.out.println(temp);
        scanner.close();
    }



    static boolean  valid(String s) {
        boolean flag = true;
        for (int i = 0 ; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                continue;
            }
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                continue;
            }
            flag = true;
        }
        return flag;
    }
}
//Tom,Lily,Tom,Lucy,Lucy,Tom,Jack,Tomy,Tomy,Tomy