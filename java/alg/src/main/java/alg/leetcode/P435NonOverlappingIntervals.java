package alg.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @link https://leetcode.cn/problems/non-overlapping-intervals/
 * @author zhangxq
 * @since 2023/6/11
 */
public class P435NonOverlappingIntervals {
    
    public static void main(String[] args) {
    
    }
    
    public int eraseOverlapIntervals(int[][] q) {
        if (q.length == 0) return 0;
        // 按照右端点排序
        Arrays.sort(q, Comparator.comparingInt(o -> o[1]));
        int res = 1, r = q[0][1];
        for (int i = 1; i < q.length; i++) {
            // 是可以选择的
            if (q[i][0] >= r) {
                res++;
                r = q[i][1];
            }
        }
        return q.length - res;
    }
}
