package alg.leetcode;

import java.util.HashMap;

/**
 * @link https://leetcode.cn/problems/subarray-sum-equals-k/
 * @author zhangxq
 * @since 2023/9/29
 */
public class P560SubarraySumEqualsK {
    
    public static void main(String[] args) {
    
    }
    
    
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // 前缀和数组
        var s  = new int[n + 1];
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + nums[i - 1];

        // 和出现次数的 hash 表
        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int t = s[i] - k;
            if (map.containsKey(t)) res += map.get(t);
            // 计算完成之后将 s[i] 加到 hash 表中
            map.put(s[i], map.getOrDefault(s[i], 0) + 1);
        }
        return res;
    }
}
