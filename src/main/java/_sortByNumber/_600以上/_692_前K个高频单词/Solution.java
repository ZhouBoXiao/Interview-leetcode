package _sortByNumber._600以上._692_前K个高频单词;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/8/17 20:00
 */
public class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>(words.length);
        // 建立哈希表统计单词频率
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // 小顶堆，相同频率下，字母顺序高的在前，方便入栈
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
            Integer o1Count = map.get(o1);
            Integer o2Count = map.get(o2);
            if (o1Count.equals(o2Count)) {
                return o2.compareTo(o1);
            } else {
                return o1Count - o2Count;
            }
        });
        // 维持topK频率的单词
        for (String word : map.keySet()) {
            queue.offer(word);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        // 利用栈特性
        LinkedList<String> stack = new LinkedList<>();
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        return stack;
    }

    public List<String> topKFrequent1(String[] words, int k) {
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(((o1, o2) -> {
                    if (o1.getValue().equals(o2.getValue())) {
                        return o1.getKey().compareTo(o2.getKey());
                    } else {
                        return o2.getValue().compareTo(o1.getValue());
                    }

                }))
                .map(Map.Entry::getKey)
                .limit(k)
                .collect(Collectors.toList());
    }
}
