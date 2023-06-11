package alg.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/find-right-interval/
 * @since 2023/6/11
 */
public class P436FindRightInterval {
    
    public static void main(String[] args) {
    
    }
    
    public int[] findRightInterval(int[][] intervals) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) map.put(intervals[i][0], i);
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[] res = new int[intervals.length];
        Arrays.fill(res, -1);
        for (int[] ins : intervals) {
            int l = 0, r = intervals.length - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (intervals[mid][0] >= ins[1]) r = mid;
                else l = mid + 1;
            }
            if (intervals[r][0] >= ins[1]) res[map.get(ins[0])] = map.get(intervals[r][0]);
        }
        return res;
    }
}
