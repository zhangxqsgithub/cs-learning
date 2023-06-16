package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/ones-and-zeroes/
 * @author zhangxq
 * @since 2023/6/16
 */
public class P474OnesAndZeroes {
    
    public static void main(String[] args) {
    
    }
    
    public int findMaxForm(String[] strs, int m, int n) {
        var dp = new int[m + 1][n + 1];
        for (var str : strs) {
            var zero = 0; var one = 0;
            for (int i = 0; i < str.length(); i++)
                if (str.charAt(i) == '0') zero++;
                else if (str.charAt(i) == '1') one++;
            for (int i = m; i >= zero; i--)
                for (int j = n; j >= one; j--)
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
        }
        return dp[m][n];
    }
}
