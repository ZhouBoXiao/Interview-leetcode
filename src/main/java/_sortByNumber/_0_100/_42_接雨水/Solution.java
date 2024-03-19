package _sortByNumber._0_100._42_接雨水;

public class Solution {
    public int trap(int[] height) {
        int length = height.length;

        int sum  =0 ;
        int leftMax = 0, rightMax =0;
        int left = 0 , right = length - 1;

        while (left < right) {

            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            if (leftMax < rightMax) {
                sum += leftMax - height[left];
                left++;

            } else {
                sum += rightMax - height[right];
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] trap = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Solution().trap(trap));
    }
}
