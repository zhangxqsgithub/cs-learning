package alg.leetcode;

import java.util.*;

/**
 * @link https://leetcode.cn/problems/top-k-frequent-elements/
 * @author zhangxq
 * @since 2023/5/31
 */
public class P347TopKFrequentElements {
    
    public static void main(String[] args) {
    
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        var cnt = new HashMap<Integer, Integer>();
        for (var n : nums) cnt.put(n, cnt.getOrDefault(n, 0) + 1);
        // 利用优先队列按照出现次数排序（倒序）
        var q = new PriorityQueue<Pair>((o1, o2) -> o2.first.compareTo(o1.first));
        for (var e : cnt.entrySet()) q.add(new Pair(e.getValue(), e.getKey()));
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            if (!q.isEmpty()) res[i] = q.poll().second;
        }
        return res;
    }
    
    record Pair(Integer first, Integer second) {}
}
