package _剑指offer._最小的k个数;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

class soultion1 {
    /***
     * 快排
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        return getLeastNumbers(arr, 0, arr.length - 1, k - 1);
    }
    private int[] getLeastNumbers(int[] arr, int low, int high, int k) {

        //int mid = low + (high - low) >> 1;
        int mid = partition(arr, low , high);
        if (mid == k) {

            return Arrays.copyOf(arr, k + 1);
        }

        return mid > k ? getLeastNumbers(arr, low, mid - 1, k) : getLeastNumbers(arr, mid + 1, high, k);
    }

    private int partition(int[] arr, int left, int right) {

        int temp = left;
        while (left < right) {
            while (left < right && arr[right] >= arr[temp]) right--;
            while (left < right && arr[left] <= arr[temp]) left++;
            swap(arr, left, right);
        }
        swap(arr, temp , right);
        return right;
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}

/***
 * 大顶推
 */
class Solution2 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        int cnt = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((v1 , v2) -> v2 - v1);
        for (int num : arr) {
            cnt++;
            if (cnt <= k) {
                queue.offer(num);
            } else if (num < queue.peek()){
                queue.poll();
                queue.offer(num);

            }
        }
        int[] res = new int[k];
        int idx = 0;
        for(int num: queue) {
            res[idx++] = num;
        }
        return res;
    }




}
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        TreeMap<Integer, Integer> map  = new TreeMap<>();

        int cnt = 0;
        for (int num: arr) {
            if (cnt < k) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                cnt++;
                continue;
            }
            Map.Entry<Integer,Integer> entry = map.lastEntry();
            if (entry.getKey()  > num) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (entry.getValue() == 1) {
                    map.pollLastEntry();
                } else {
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
            }


        }
        int[] res = new int[k];
        int idx = 0;
        for (Map.Entry<Integer, Integer> num : map.entrySet()) {
            int size = num.getValue();
            while (size-- > 0) {
                res[idx++] = num.getKey();
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0,2,0,5};
        System.out.println(Arrays.toString(new Solution().getLeastNumbers(arr, 5)));
    }
}