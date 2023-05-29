package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/burst-balloons/
 * @author zhangxq
 * @since 2023/5/29
 */
public class P312BurstBalloons {
    
    public static void main(String[] args) {
    
    }
    
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] a = new int[n + 2];
        // 左右边界各补上 1，并且这两个 1 是不能被打掉的
        a[0] = 1; a[a.length - 1] = 1;
        for (int i = 1; i <= n; i++) a[i] = nums[i - 1];
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 3; len <= n + 2; len++) {
            for (int i = 0; i + len - 1 <= n + 1; i++) {
                int j = i + len - 1;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + a[i] * a[k] * a[j]);
                }
            }
        }
        return dp[0][n + 1];
    }
}
