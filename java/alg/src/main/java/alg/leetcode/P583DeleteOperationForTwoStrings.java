package alg.leetcode;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/delete-operation-for-two-strings/
 * @since 2023/9/29
 */
public class P583DeleteOperationForTwoStrings {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 最长子序列问题
     * 删除字符数量的最小值，等价于剩余字符数量最大值
     */
    public int minDistance(String word1, String word2) {
        char[] s1 = word1.toCharArray(), s2 = word2.toCharArray();
        int n = s1.length, m = s2.length;
        int[][] f = new int[2][m + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i & 1][j] = Math.max(f[i - 1 & 1][j], f[i & 1][j - 1]);
                if (s1[i - 1] == s2[j - 1]) f[i & 1][j] = Math.max(f[i & 1][j], f[i - 1 & 1][j - 1] + 1);
            }
        }
        return n + m - 2 * f[n & 1][m];
    }
}
