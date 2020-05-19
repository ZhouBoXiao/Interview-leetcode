package _sortByNumber._101_200._127_单词接龙_双向BFS;
import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        wordList.add(beginWord);

        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        queue1.offer(beginWord);
        queue2.add(endWord);
        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();
        visited1.add(beginWord);
        visited2.add(endWord);
        int count = 0;
        Set<String> allWordSet = new HashSet<>(wordList);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            count++;

            if (queue1.size() > queue2.size()) {
                Queue<String> tmp = queue1;
                queue1 = queue2;
                queue2 = tmp;
                Set<String> t = visited1;
                visited1 = visited2;
                visited2 = t;
            }
            int size = queue1.size();

            while (size-- > 0) {
                String s = queue1.poll();

                assert s != null;
                char[] chars = s.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char ch = chars[i];
                    for (char a = 'a'; a < 'z'; a++) {
                        if (ch != a) {
                            chars[i] = a;
                            String str = String.valueOf(chars);

                            if (visited1.contains(str)) {
                                continue;
                            }
                            if (visited2.contains(str)) {
                                return count+1;
                            }
                            if (allWordSet.contains(str)) {
                                queue1.offer(str);
                                visited1.add(str);
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
