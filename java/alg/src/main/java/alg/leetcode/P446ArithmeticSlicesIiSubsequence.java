package alg.leetcode;

import java.util.*;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/arithmetic-slices-ii-subsequence/
 * @since 2023/6/12
 */
public class P446ArithmeticSlicesIiSubsequence {
    
    public static void main(String[] args) {
    
    }
    
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        HashMap<Long, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = new HashMap<Long, Integer>();
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                Integer cnt = dp[j].getOrDefault(diff, 0);
                res += cnt;
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + cnt + 1);
            }
        }
        return res;
    }
}
