package _sortByNumber._101_200._169;

public class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int majority = 0;
        for (int i = 0; i < nums.length; i++) {
           if (cnt == 0) {
               majority = nums[i];
               cnt++;
           } else {
               cnt = majority == nums[i]? cnt++ : cnt--;
           }
        }
        return  majority ;
    }
}
