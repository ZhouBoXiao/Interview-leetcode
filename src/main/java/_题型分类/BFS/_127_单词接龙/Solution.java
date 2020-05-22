package _题型分类.BFS._127_单词接龙;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/4/29 16:23
 */

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> q1 = new LinkedList<>();
        q1.add(beginWord);
        Queue<String> q2 = new LinkedList<>();
        q2.add(endWord);
        Set<String> s1 = new HashSet<>();
        s1.add(beginWord);
        Set<String> s2 = new  HashSet<>();
        s2.add(endWord);
        int cnt = 0;
        Set<String> allWordSet = new HashSet<>(wordList);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            cnt++;
            if (q1.size() > q2.size()) {
                Queue<String> tmp = q1;
                q1 = q2;
                q2 = tmp;
                Set<String> t = s1;
                s1 = s2;
                s2 = t;
            }
            int size = q1.size();

            while (size-- > 0) {
                String s = q1.poll();
                assert s != null;
                char[] chars = s.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char ch = chars[i];
                    for (char a = 'a'; a < 'z'; a++) {
                        if (ch != a) {
                            chars[i] = a;
                            String str = String.valueOf(chars);

                            if (s1.contains(str)) {
                                continue;
                            }
                            if (s2.contains(str)) {
                                return cnt+1;
                            }
                            if (allWordSet.contains(str)) {
                                q1.offer(str);
                                s1.add(str);
                            }
                        }

                    }
                    chars[i] = ch;

                }
            }
        }
        return 0;
    }
}
