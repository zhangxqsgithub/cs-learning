package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/combination-sum-iv/
 * @author zhangxq
 * @since 2023/6/2
 */
public class P377CombinationSumIV {
    
    public static void main(String[] args) {
    
    }
    
    public int combinationSum4(int[] nums, int m) {
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int i = 1; i <= m; i++) {
            for (var j : nums) {
                if (i >= j) dp[i] += dp[i - j];
            }
        }
        return dp[m];
    }
}
