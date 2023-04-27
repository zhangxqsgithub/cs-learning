package alg.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/palindrome-partitioning-ii/
 * @author zhangxq
 * @since 2023/4/27
 */
public class P132PalindromePartitioningII {
    
    public static void main(String[] args) {
    
    }
    
    public int minCut(String s) {
        int n = s.length();
        s = " " + s;
        boolean[][] g = new boolean[n + 1][n + 1];
        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= n; i++) {
                if (i == j) g[i][j] = true;
                else if (s.charAt(i) == s.charAt(j))
                    g[i][j] = i + 1 > j - 1 || g[i + 1][j - 1];
            }
        }
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (g[j][i])
                    f[i] = Math.min(f[i], f[j - 1] + 1);
            }
        }
        return f[n] - 1;
    }
}
