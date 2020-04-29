package _401_500._433_最小基因变化;
import java.util.*;

public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<String>(Arrays.asList(bank));
        if (!set.contains(end)) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        char[] temp = new char[]{'A', 'C', 'G', 'T'};
        queue.offer(start);
        set.remove(start);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int cnt = queue.size();
            while (cnt-- > 0) {
                char[] chars = Objects.requireNonNull(queue.poll()).toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (int j = 0; j < 4; j ++) {
                        chars[i] = temp[j];
                        String tmp = new String(chars);
                        if (end.equals(tmp)) {
                            return step;
                        } else if (set.contains(tmp)){
                            queue.offer(tmp);
                            set.remove(tmp);

                        }
                    }
                    chars[i] = old;
                }
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        String start = "AACCTTGG";
        String end = "AATTCCGG";
        String[] bank = "AATTCCGG,AACCTGGG,AACCCCGG,AACCTACC".split(",");
        new Solution().minMutation(start, end, bank);
    }
}
