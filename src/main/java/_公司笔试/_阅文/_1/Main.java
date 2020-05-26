package _公司笔试._阅文._1;

import java.util.*;
/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/19 20:17
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            String[] strs = s.split(",");
            for (int j = 0; j < n; j++) {
                if (j!= i) {
                    if ("1".equals(strs[j])){
                        if (!uf.isSame(i,j))
                            uf.union(i,j);
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < uf.parents.length; i++) {
            set.add(uf.parents[i]);
        }
        System.out.println(set.size());
//        int[] nums1 = new int[]{7,8,9,10,11,12};
//        int[] nums2 = new int[]{1,2,3,4,5,6};
//        System.out.println(new Solution().solve(new ArrayList<>(Arrays.asList("C1",  "C5" ,"C4","C3"))));
    }
}
class UnionFind {
    int[] parents;

    public UnionFind(int totalNodes) {
        parents = new int[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            parents[i] = i;
        }
    }
    void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 != root2) {
            parents[root2] = root1;
        }
    }

    int find(int node) {
        while (parents[node] != node) {
            parents[node] = parents[parents[node]];
            node = parents[node];
        }
        return node;
    }

    boolean isSame(int node1, int node2) {
        return find(node1) == find(node2);
    }
}

class Solution{
    int cnt =0;
    int[] temp;
    public int  solve(List<String> list) {
        int n = list.size();
        int[] nums = new int[n];
        temp = new int[n];
        for (int i = 0; i < n; i++) {
            String temp = list.get(i);

            if (temp.charAt(0) == 'C') {
                nums[i] = 10 + temp.charAt(1) - '0';
            } else if (temp.charAt(0) == 'D') {
                nums[i] = 20 + temp.charAt(1) - '0';
            } else if (temp.charAt(0) == 'B') {
                nums[i] = 30 + temp.charAt(1) - '0';
            }
        }

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < nums[i-1]) {
                cnt++;
                int index = rightBound(nums,  i , nums[i-1]);
                if (index >= n) {
                    index = n-1;
                }
                swap(nums, index, i-1);
                i = 0;
            }

        }
        return cnt;
    }
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    int rightBound(int[] nums, int left,  int target) {
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        return right;
    }


}

class Solution4 {

    public int solve(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i - 1, right = i+1;
            while (right < nums.length && nums[right] > nums[i] ) right++;
            while (left >= 0 && nums[left] > nums[i] ) left--;
            max = Math.max(max, (right - left - 1) * nums[i]);
        }
        return max;
    }
}


class Solution3 {

    public boolean solve(int[][] nums, int target) {
        if (nums.length == 0 || nums[0].length == 0) {
            return false;
        }
        int n = nums.length;
        int m = nums[0].length;
        for (int i = 0, j = m - 1; j >= 0 && i < n ;) {
            if (nums[i][j] == target) {
                return true;
            } else if (nums[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

}


class Solution2 {
    int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return left;
    }
    public int[] solve(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[] res = new int[k];
        int sum = 0;
        int cnt = 0;
        for (int i = 0, j = 0 ; i < n && j < n ; ) {
            sum = nums1[i] + nums2[j];
            res[cnt++] = sum;
            if (cnt == k) {
                break;
            }
            if (i == n - 1 && j < n - 1) {
                j++;
            } else if (j == n - 1 && i < n - 1) {
                i++;
            } else if (nums1[i] < nums2[j]  && i < n - 1) {

            } else if (j < n - 1){


            }
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        return res;
    }
}

class Solution1 {
    public int solve(int[] nums) {
        if (nums.length == 0 ) return -1;
        int maj = nums[0] ;
        int cnt = 1;
        for (int i = 1 ; i < nums.length; i++ ) {
            cnt = maj == nums[i] ? cnt + 1 : cnt - 1;
            if ( cnt == 0 ) {
                maj = nums[i];
                cnt = 1;
            }
        }
        cnt = 0;
        for (int i = 0 ; i < nums.length; i++ ) {
            if ( nums[i] == maj) {
                cnt++;
            }
        }
        return cnt > nums.length/2 ? maj : -1;
    }
}



