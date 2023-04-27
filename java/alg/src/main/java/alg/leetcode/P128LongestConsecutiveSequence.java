package alg.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/longest-consecutive-sequence/
 * @since 2023/4/27
 */
public class P128LongestConsecutiveSequence {
    
    public static void main(String[] args) {
    
    }
    
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (var num : nums) set.add(num);
        var res = 0;
        for (var x : set) {
            if (set.contains(x) && !set.contains(x - 1)) {
                int y = x;
                while (set.contains(y + 1)) y++;
                res = Math.max(res, y - x + 1);
            }
        }
        return res;
    }
}
