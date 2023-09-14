package alg.leetcode;

import alg.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @link https://leetcode.cn/problems/ipo/
 * @author zhangxq
 * @since 2023/9/14
 */
public class P502IPO {
    
    public static void main(String[] args) {
        var solution = new P502IPO();
        var res1 = solution.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 9, 10});
        System.out.println(res1);
    }
    
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        var p = new int[n][2];
        for (int i = 0; i < n; i++) p[i] = new int[]{capital[i], profits[i]};
        // 根据成本排序
        Arrays.sort(p, Comparator.comparingInt(o -> o[0]));
        // 大顶堆
        var heap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        int idx = 0;
        while (k > 0) {
            k--;
            while (idx < n && p[idx][0] <= w) {
                heap.add(p[idx][1]);
                idx++;
            }
            if (!heap.isEmpty()) w += heap.poll();
            else break;
        }
        return w;
    }
}
