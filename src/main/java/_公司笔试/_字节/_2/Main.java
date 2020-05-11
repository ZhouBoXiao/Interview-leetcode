package _公司笔试._字节._2;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/11 9:59
 */

import java.util.*;

public class Main {
    static int MOD = 835672545;

    private int maxLength = -1;
    private Set<String> wordSet = new HashSet<>();
    private Map<Integer, List <String>> mapPosToStrings = new HashMap<>();

    List<String> calculateResult(String s, int currentPos) {
        if (currentPos == s.length()) {
            List<String> result = new ArrayList<>();
            result.add("");
            return result;
        }
        if (mapPosToStrings.containsKey(currentPos)) {
            return mapPosToStrings.get(currentPos);
        }
        List<String> result = new ArrayList<>();
        mapPosToStrings.put(currentPos, result);

        for (int i = 1; i <= maxLength && currentPos + i <= s.length(); i++) {
            String subString = s.substring(currentPos, currentPos + i);
            if (wordSet.contains(subString)) {
                List<String> returnStrings = calculateResult(s, currentPos + i);
                for (String returnString: returnStrings) {
                    if ("".equals(returnString)) {
                        result.add(subString);
                    } else {
                        result.add(subString + " " + returnString);
                    }
                }
            }
        }

        return result;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        for (String word: wordDict) {
            wordSet.add(word);
            maxLength = Math.max(maxLength, word.length());
        }

        return calculateResult(s, 0);
    }
}
/*
aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab
9
a
aa
aaa
aaaa
aaaaaa
aaaaaaa
aaaaaaaa
aaaaaaaaa
aaaaaaaaaa
/*
"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
 */