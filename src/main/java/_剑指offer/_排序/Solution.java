package _剑指offer._排序;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

abstract class Sort<T extends Comparable<T>> {

    abstract void sort(T[] nums);

    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }
    protected void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

/**
 * 选择排序
 */

class Selection<T extends Comparable<T>> extends Sort<T> {

    @Override
    void sort(T[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(nums[j], nums[min])) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }
}

/**
 * 冒泡排序
 */
class Bubble<T extends Comparable<T>> extends Sort<T> {

    @Override
    void sort(T[] nums) {
        int N = nums.length;
        boolean isSorted = false;
        for (int i = N - 1; i > 0 && !isSorted; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (less(nums[j + 1], nums[j])) {
                    isSorted = false;
                    swap(nums, j, j + 1);
                }
            }
        }
    }
}

/**
 * 插入排序
 */

class Insertion<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(nums[j], nums[j - 1]); j--) {
                swap(nums, j, j - 1);
            }
        }

    }
}

/**
 * 希尔排序
 */


class Shell<T extends Comparable<T>> extends Sort<T> {

    @Override
    void sort(T[] nums) {
        int N = nums.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j--) {
                    swap(nums, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}

/***
 * 归并排序
 */

abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {

    protected T[] aux;

    protected  void merge(T[] nums, int l, int m, int h) {
        int i = l, j = m + 1;
        for (int k = l; k <= h; k++) {
            aux[k] = nums[k];
        }
//        System.arraycopy(nums,0 , aux, 0 ,h-l+1);
        for (int k = l; k <= h; k ++) {
            if (i > m) {
                nums[k] = aux[j++];
            } else if (j > h){
                nums[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) <= 0) {
                nums[k] = aux[i++];
            } else {
                nums[k] = aux[j++];
            }
        }
    }

}

class Up2DownMergeSort<T extends Comparable<T>> extends MergeSort<T> {

    @Override
    public void sort(T[] nums) {
        aux = (T[]) new Comparable[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int mid = l + (h - l) / 2;
        sort(nums, l, mid);
        sort(nums, mid + 1, h);
        merge(nums, l, mid, h);
    }
}

/**
 * 快速排序
 */
class QuickSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    void sort(T[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    private void shuffle(T[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    private void sort(T[] nums, int l, int h) {
        if (h <= l)
            return ;
        int j = partition(nums, l, h);
        sort(nums, l, j -1);
        sort(nums, j + 1, h);
    }

    protected int partition(T[] nums, int l, int h) {
        int i = l, j = h + 1;
        T v = nums[l];
        while (true) {
            while (less(nums[++i], v) && i != h) ;
            while (less(nums[--j], v) && j != l) ;
            if (i >= j) break;
            swap(nums, i , j);

        }
        swap(nums, l , j);
        return j;
    }
//    int partition1(int[] nums, int left, int right) {
//        int temp = left;
//        while (left < right) {
//            while(left < right && nums[right] >= nums[temp]) right--;
//            while(left < right && nums[left] <= nums[temp]) left++;
//
//            swap(nums, left, right);
//        }
//        swap(nums, temp, right);
//    }
}

/**
 * 算法改进
 * 1、切换到插入排序
 * 2、三数取中
 * 3、三向切分
 */
class ThreeWayQuickSort<T extends Comparable<T>> extends QuickSort<T> {


    protected void sort(T[] nums, int l, int h) {
        if (h <= l) return;
        int lt = l, i = l + 1, gt = h;
        T v = nums[l];
        while (i <= gt) {
            int cmp = nums[i].compareTo(v);
            if (cmp < 0) {
                swap(nums, lt++, i++);
            } else if (cmp > 0) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }
        sort (nums, l, lt - 1);
        sort(nums, gt + 1, h);
    }

    /**
     * 基于切分的快速选择算法
     * 可以利用这个特性找出数组的第 k 个元素。
     * @param nums
     * @param k
     * @return
     */
    public T select(T[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (h > l) {
            int j = partition(nums, l, h);

            if (j == k) {
                return nums[k];

            } else if (j > k) {
                h = j - 1;

            } else {
                l = j + 1;
            }
        }
        return nums[k];
    }
}

class HeapSort{
    void sort(int[] arr) {
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }
    }
    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k+1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

}



public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{4,6,1,3,9,5,3,6,8,9};
        new HeapSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
