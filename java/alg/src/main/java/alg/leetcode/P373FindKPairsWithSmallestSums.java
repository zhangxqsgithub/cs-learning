package alg.leetcode;

import java.util.*;

/**
 * @link https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/
 * @author zhangxq
 * @since 2023/6/2
 */
public class P373FindKPairsWithSmallestSums {
    
    public static void main(String[] args) {
        var solution = new P373FindKPairsWithSmallestSums();
        var res = solution.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 10);
        System.out.println(res);
    }
    
    /**
     * 多路归并
     */
    public List<List<Integer>> kSmallestPairs(int[] a, int[] b, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (a.length == 0 || b.length == 0) return res;
        int n = a.length, m = b.length;
        var heap = new PriorityQueue<int[]>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < m; i++) heap.add(new int[]{a[0] + b[i], 0, i});
        // 边往 heap 里增加元素，边计算
        while (k-- != 0 && heap.size() != 0) {
            var t = heap.poll();
            res.add(Arrays.asList(a[t[1]], b[t[2]]));
            if (t[1] + 1 < n) {
                heap.add(new int[]{a[t[1] + 1] + b[t[2]], t[1] + 1, t[2]});
            }
        }
        return res;
    }
    
    // 自创的交换指针方法
    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        if (nums1.length < nums2.length) {
            int[] t = nums1;
            nums1 = nums2;
            nums2 = t;
        }
        List<List<Integer>> res = new ArrayList<>();
        int a1 = 0, b1 = 0, a2 = 1, b2 = 0;
        int i = 0;
        while (a1 < nums1.length && b1 < nums2.length && i < k) {
            if (nums1[a1] + nums2[b1] <= nums1[a2] + nums2[b2]) {
                res.add(Arrays.asList(nums1[a1], nums2[b1]));
                i++;
                b1++;
                if (b1 == nums2.length) { a1++; b1 = 0; }
            }
            else { // switch
                int t1 = a1, t2 = b1;
                a1 = a2; b1 = b2;
                a2 = t1; b2 = t2;
            }
        }
        return res;
    }
}
