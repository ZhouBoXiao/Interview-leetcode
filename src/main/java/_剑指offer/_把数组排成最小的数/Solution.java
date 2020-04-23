package _剑指offer._把数组排成最小的数;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public String minNumber(int[] nums) {
        String[] t = new String[nums.length];
        for(int i = 0;i < nums.length;i++)
            t[i] = String.valueOf(nums[i]);
        Arrays.sort(t,(x,y)->(x + y ).compareTo(y + x));
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < nums.length;i++)
            sb.append(t[i]);
        return sb.toString();
    }
}
