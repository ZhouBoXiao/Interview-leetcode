package _公司笔试.leetcode._189_周赛._1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/17 11:00
 */
public class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int cnt= 0;
        for (int i = 0; i < startTime.length ; i++) {
            if (queryTime>= startTime[i] && queryTime<= endTime[i]) {
                cnt++;
            }
        }
        return cnt;
    }
    public String arrangeWords(String text) {
        text = text.toLowerCase();
        String[] strs = text.split(" ");
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        StringBuilder sb = new StringBuilder(strs[0]);
        sb.setCharAt(0, (char) (sb.charAt(0)- 32));
        for (int i = 1; i < strs.length; i++) {
            sb.append(" ").append(strs[i]);
        }
        return sb.toString();
    }

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> res = new ArrayList<>();
        List<Integer> res1 = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            res1.add(i);
        }
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            Collections.sort(favoriteCompanies.get(i));
        }
        for (int i = 0; i < favoriteCompanies.size(); i++) {

            for (int j = 0;  j < favoriteCompanies.size(); j++) {
                if (j == i) continue;
                if (compare(favoriteCompanies.get(i), favoriteCompanies.get(j))) {
                    res1.set(i, -1);
                    break;
                }
            }
        }
        res = res1.stream().filter(a->a!=-1).collect(Collectors.toList());
        return res;
    }

    private boolean compare(List<String> s1, List<String> s2) {
        if (s1.size() >= s2.size()) return false;
        int cnt=0;
        Set<String> set1 = new HashSet<>(s2);

        for (int i = 0; i < s1.size(); i++) {
            if (!set1.contains(s1.get(i))) {
                return false;
            }
        }
        return true;
    }
    //[["nxaqhyoprhlhvhyojanr","ovqdyfqmlpxapbjwtssm","qmsbphxzmnvflrwyvxlc","udfuxjdxkxwqnqvgjjsp","yawoixzhsdkaaauramvg","zycidpyopumzgdpamnty"],["nxaqhyoprhlhvhyojanr","ovqdyfqmlpxapbjwtssm","udfuxjdxkxwqnqvgjjsp","yawoixzhsdkaaauramvg","zycidpyopumzgdpamnty"],["ovqdyfqmlpxapbjwtssm","qmsbphxzmnvflrwyvxlc","udfuxjdxkxwqnqvgjjsp","yawoixzhsdkaaauramvg","zycidpyopumzgdpamnty"]]
    //[["arrt","knzg","zibv"],["cffi","owqv"],["knzg","owqv","qzeq"],["arrt","cffi"],["arrt","knzgi","owqv","qzeq","zibv"]]
    public static void main(String[] args) {
        List<List<String>> res = new ArrayList<>();
        List<String> r1 = Arrays.asList("arrt","knzg","zibv");
        List<String> r2 = Arrays.asList("cffi","owqv");
        List<String> r3 = Arrays.asList("knzg","owqv","qzeq");
        List<String> r4 = Arrays.asList("arrt","cffi");
        List<String> r5 = Arrays.asList("arrt","knzg","owqv","qzeq","zibv");

        res.add(r1);
        res.add(r2);
        res.add(r3);
        res.add(r4);
        res.add(r5);
        new Solution().peopleIndexes(res);
    }
}
