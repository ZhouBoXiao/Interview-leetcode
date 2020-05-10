package _动态规划._单词拆分;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/10 22:23
 */
public class Solution {
    public boolean wordBreak1(String s, List<String> wordDict) {
        int m = s.length();
        if (s.length() == 0) return false;
        boolean[] f = new boolean[m + 1];
        f[0] = true;

        for(int i = 1; i <= s.length(); i++){
            for(String w: wordDict){
                int len = w.length();
                if(i >= len && f[i - len] == true
                        && s.substring(i - len, i).equals(w)){
                    f[i] = true;
                    break;
                }
            }

            // for(int j = 0; j < i; j++){
            //     if(f[j] == true && wordDict.contains(s.substring(j, i))){
            //         f[i] = true;
            //         break;
            //     }
            // }
        }
        return f[m];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        HashMap<Integer,Boolean> memo = new HashMap<>();
        return getResult(s,0,set,memo);
    }

    private boolean getResult(String s, int start, HashSet<String> set, HashMap<Integer, Boolean> memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        for (int i = start;i < s.length(); i++) {
            if (set.contains(s.substring(start, i + 1))) {
                if (getResult(s, i+1, set, memo)) {
                    memo.put(start,true);
                    return true;
                }
            }
        }
        memo.put(start,false);
        return false;
    }

    public boolean wordBreak3(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (String str : wordDict) {
            max = Math.max(str.length(),max);
            set.add(str);
        }
        // 记录map，记录重复的计算的结果
        HashMap<Integer,Boolean> map = new HashMap<>();
        return getResult(s,0,set,max,map);
    }

    /**
     *
     * @param s
     * @param start  表示索引开始位置
     * @param set    字段中字符串的集合
     * @param max    每次遍历s时不可以超出max长度，否则肯定为false
     * @param map    记忆表
     * @return
     */
    private boolean getResult(String s, int start, HashSet<String> set,int max,HashMap<Integer,Boolean> map) {
        if(start == s.length()){
            return true;
        }
        if(map.containsKey(start)){
            return map.get(start);
        }
        // 关键步骤： 遍历的时候加上max的长度限制，避免无限遍历至s结尾
        for (int i = start; i < start + max && i < s.length(); i++) {
            if(set.contains(s.substring(start,i + 1))){
                if(getResult(s,i+1,set,max,map)){
                    map.put(start,true);
                    return true;
                }
            }
        }
        map.put(start,false);
        return false;
    }

}
/*
"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
 */