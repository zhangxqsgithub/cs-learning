package alg.leetcode;

import java.util.HashMap;

/**
 * @link https://leetcode.cn/problems/longest-harmonious-subsequence/
 * @author zhangxq
 * @since 2023/9/30
 */
public class P594LongestHarmoniousSubsequence {
    
    public static void main(String[] args) {
    
    }
    
    public int findLHS(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        for (var num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        int res = 0;
        for (var e : map.entrySet()) {
            int k = e.getKey(), v = e.getValue();
            if (map.containsKey(k - 1)) {
                res = Math.max(res, v + map.get(k - 1));
            }
        }
        return res;
    }
}
