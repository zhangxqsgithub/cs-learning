package alg.leetcode;

import java.util.HashSet;

/**
 * @link https://leetcode.cn/problems/continuous-subarray-sum/
 * @author zhangxq
 * @since 2023/9/25
 */
public class P523ContinuousSubarraySum {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 求区间和可以用前缀和算法
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        var n = nums.length;
        if (k == 0) {
            for (int i = 1; i < n; i++)
                if (nums[i - 1] == 0 && nums[i] == 0)
                    return true;
            return false;
        }
        
        // 前缀和数组
        var s = new int[n + 1];
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + nums[i - 1];
        // 用于判断每个余数是否存在
        var set = new HashSet<Integer>();
        
        for (int i = 2; i <= n; i++) {
            set.add(s[i - 2] % k);
            if (set.contains(s[i] % k)) return true;
        }
        return false;
    }
}
