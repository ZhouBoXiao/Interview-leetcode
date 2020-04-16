package _剑指offer._后序遍历;

public class Solution {
    public boolean VerifySequenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return judge(sequence, 0, sequence.length-1);
    }

    boolean judge(int[] sequence, int l, int r) {
        if (l >= r) {
            return true;
        }
        int i = r;
        while (i > l && sequence[i-1] > sequence[r]) {
            i--;
        }
        for (int j = i; j >= l; j--) {
            if (sequence[j] > sequence[i]) {
                return false;
            }
        }
        return judge(sequence, l, i-1) && judge(sequence, i, r-1);
    }
}
