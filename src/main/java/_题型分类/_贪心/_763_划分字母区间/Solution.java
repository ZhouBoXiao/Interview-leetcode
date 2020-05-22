package _题型分类._贪心._763_划分字母区间;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/2 14:29
 */
public class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] index = new int[26];
        for (int i = 0; i < S.length() ; i++) {
            index[S.charAt(i) - 'a'] = i;
        }
        List<Integer> list = new ArrayList<>();
        int left =0 ,right = 0;
        while (left < S.length()) {
            right = left;
            for (int i = left; i < S.length() && i <= right; i++) {
                int temp = index[S.charAt(i) - 'a'];
                if (temp > right)
                    right = temp;
            }
            list.add(right - left + 1);
            left = right+ 1;

        }
        return list;
    }
}
