package _sortByNumber._101_200._126_单词接龙2;

import java.util.*;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/6/7 21:09
 */
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return ans;
        }

        Map<String, List<String>> map = new HashMap<>();
        bfs(beginWord, endWord, wordList, map);
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);
        findLaddersHelper(beginWord, endWord, map, temp, ans);
        return ans;
    }
    //递归实现了双向搜索
    private void bfs(String beginWord, String endWord, List<String> wordList, Map<String, List<String>> map) {
        Set<String> set1 = new HashSet<>();
        set1.add(beginWord);
        Set<String> set2 = new HashSet<>();
        set2.add(endWord);
        Set<String> wordSet = new HashSet<>(wordList);
        bfsHelper(set1, set2, wordSet, true, map);
    }

    private boolean bfsHelper(Set<String> set1, Set<String> set2, Set<String> wordSet, boolean direction, Map<String, List<String>> map) {
        if (set1.isEmpty()) {
            return false;
        }
        if (set1.size() > set2.size()) {
            return bfsHelper(set2, set1, wordSet, !direction, map);
        }
        wordSet.removeAll(set1);
        wordSet.removeAll(set2);
        boolean done = false;
        Set<String> set = new HashSet<>();
        for (String str : set1) {
            for (int i = 0; i < str.length(); i++) {
                String name;
                char[] chars = str.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (chars[i] == ch) {
                        continue;
                    }
                    chars[i] = ch;

                    String word = new String(chars);

                    String key = direction ? str : word;
                    String val = direction ? word : str;

                    List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<>();

                    if (set2.contains(word)) {
                        done = true;
                        list.add(val);
                        map.put(key, list);
                    }
                    if (!done && wordSet.contains(word)) {
                        set.add(word);
                        list.add(val);
                        map.put(key, list);
                    }
                }
            }
        }
        //一般情况下新扩展的元素会多一些，所以我们下次反方向扩展  set2
        return done || bfsHelper(set2, set, wordSet, !direction, map);
    }

    private void findLaddersHelper(String beginWord, String endWord, Map<String, List<String>> map, List<String> temp, List<List<String>> ans) {
        if (beginWord.equals(endWord)) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        List<String> neighbors = map.getOrDefault(beginWord, new ArrayList<>());
        for (String neighbor : neighbors) {
            temp.add(neighbor);
            findLaddersHelper(neighbor, endWord, map, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
}
