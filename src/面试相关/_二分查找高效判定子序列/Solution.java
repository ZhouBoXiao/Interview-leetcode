package 面试相关._二分查找高效判定子序列;

import java.util.ArrayList;

public class Solution {
    boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        // 对 t 进行预处理
        ArrayList<Integer>[] index = new ArrayList[256];
        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            if (index[c] == null)
                index[c] = new ArrayList<>();
            index[c].add(i);
        }

        // 串 t 上的指针
        int j = 0;
        // 借助 index 查找 s[i]
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            // 整个 t 压根儿没有字符 c
            if (index[c] == null) return false;
            int pos = left_bound(index[c], j);
            // 二分搜索区间中没有找到字符 c
            if (pos == index[c].size()) return false;
            // 向前移动指针 j
            j = index[c].get(pos) + 1;
        }
        return true;
    }

    // 查找左侧边界的二分查找
    int left_bound(ArrayList<Integer> arr, int tar) {
        int lo = 0, hi = arr.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (tar > arr.get(mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
