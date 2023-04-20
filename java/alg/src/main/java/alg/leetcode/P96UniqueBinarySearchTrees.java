package alg.leetcode;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/unique-binary-search-trees/
 * @since 2023/4/20
 */
public class P96UniqueBinarySearchTrees {
    
    public static void main(String[] args) {
    
    }
    
    public int numTrees(int n) {
        var dp = new int[n + 1];
        dp[0] = 1;
        for (var i = 1; i <= n; i++) {
            for (var j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
