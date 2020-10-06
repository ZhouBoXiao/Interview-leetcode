package _sortByNumber._101_200._128_最长连续序列;

import java.util.*;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/18 23:00
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int longest = 0;
        int max = 0;
        for (int num : nums) {
            if (set.remove(num)) {
                longest = 0;
                int cur = 1;
                while (set.remove(num-cur)) cur++;
                longest += cur;
                cur = 1;
                while (set.remove(num+cur)) cur++;
                longest += cur;
                max = Math.max(max, longest-1);
            }

        }
        return max;
    }
    public int longestConsecutive1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int result = 0;
        for(int num: nums) {
            set.add(num);
        }
        for(int num: nums) {
            if(set.contains(num - 1)) continue;
            int r = num;
            while(set.contains(r)) r++;
            result = Math.max(result, r - num);
        }
        return result;
    }


    //从图论的角度去思考这个问题，如果我们在v和v+1之间连一条边，那么这个问题就变成了寻找图中最大连通集的问题。
    //
    //这个问题我们可以用并查集来解决，我们只需要用两个hash map 同时维护并查集，和并查集中每一个连通集的大小即可。
    //
/*

    Map<Integer, Integer> a = new HashMap<>();
    int find(int x) {
        // return a.count(x)?a[x]=find(a[x]):x;
        return a.containsKey(x) ? a.put(x, find(a.get(x))) : x;
    }
    public int longestConsecutive2(int[] nums) {

        for (int num : nums) {
            a.put(num, num + 1);
        }
        int ans = 0;
        for (int num : nums) {
            int y = find(num + 1);
            ans = Math.max(ans, y - num);
        }
        return ans;
    }
*/

}
/*
unordered_map<int,int> a,b;
    int find(int x){
        return a.count(x)?a[x]=find(a[x]):x;
    }
    int longestConsecutive(vector<int>& nums) {
        for(auto i:nums)
            a[i]=i+1;
        int ans=0;
        for(auto i:nums){
            int y=find(i+1);
            ans=max(ans,y-i);
        }
        return ans;
    }
 */
