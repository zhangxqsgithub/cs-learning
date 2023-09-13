package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/predict-the-winner/
 * @author zhangxq
 * @since 2023/9/12
 */
public class P486PredictTheWinner {
    
    public static void main(String[] args) {
    
    }
    
    public boolean predictTheWinner(int[] nums) {
        var n = nums.length;
        var dp = new int[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                var j = i + len - 1;
                if (len == 1) dp[i][j] = nums[i];
                else {
                    dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
