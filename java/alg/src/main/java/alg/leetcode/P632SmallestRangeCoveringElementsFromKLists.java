package alg.leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @link https://leetcode.cn/problems/smallest-range-covering-elements-from-k-lists/
 * @author will
 * @since 2024/3/25
 */
public class P632SmallestRangeCoveringElementsFromKLists {
    
    /**
     * 找到一个最小区间，使得 k 个列表中的每一个列表至少有一个数字包含在其中。
     * 在 nums 中，每个数组拿出其中一个值，在这些值中找出最小值和最大值，就是多个数组的最小区间。
     * 需要遍历完 nums 中所有的数字，才能求出所有数组的最小区间。
     * k 路归并问题。
     * 时间复杂度 nlogk
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        var res = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        int max = Integer.MIN_VALUE;
        var heap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        // 先将所有数组中的第一个元素加入堆中
        for (int i = 0; i < k; i++) {
            heap.offer(new int[]{nums.get(i).get(0), i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        while (!heap.isEmpty()) {
            var t = heap.poll();
            int l = t[0], r = max;
            // 找到最小区间
            if (res[0] == Integer.MIN_VALUE || r - l < res[1] - res[0]) {
                res[0] = l; res[1] = r;
            }
            // 将下一个元素加入堆
            int row = t[1], col = t[2] + 1;
            if (col >= nums.get(row).size()) break;
            heap.offer(new int[]{nums.get(row).get(col), row, col});
            max = Math.max(max, nums.get(row).get(col));
        }
        return res;
    }
}
