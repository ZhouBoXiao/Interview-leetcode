package _题型分类._贪心._665_非递减数列;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/2 12:59
 */
public class Solution {
    public boolean checkPossibility(int[] nums) {
        if(nums.length < 3){
            return true;
        }
        int count = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                count++;
                if(count > 1){
                    break;
                }
                if(i-1 >=0&&nums[i-1] > nums[i+1]){
                    nums[i+1] = nums[i];
                } else{
                    nums[i] = nums[i+1];
                }
            }
        }
        return count <= 1;
    }
}
