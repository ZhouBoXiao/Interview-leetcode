package _sortByNumber._0_100._14_最长公共前缀;

public class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0 || strs[0].length() == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int res = 0;
        boolean flag = true;
        int min = Integer.MAX_VALUE;
        String s = "";
        for (int i = 0; i < strs.length; i++) {

            min = Math.min(min, strs[i].length());

        }
        for (int i = 0; i < min; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (j == 0) {
                    continue;
                } else if (strs[j].charAt(i) != strs[j-1].charAt(i)) {
                    flag = false;
                    return strs[j].substring(0, i);
                }
            }
        }
        return strs[0].substring(0,min);
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"cc","cc","c"};

        System.out.println(new Solution().longestCommonPrefix(strs));

    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }

}
