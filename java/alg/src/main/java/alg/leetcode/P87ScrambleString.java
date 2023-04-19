package alg.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/scramble-string/
 * @author zhangxq
 * @since 2023/4/18
 */
public class P87ScrambleString {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 递归方式
     */
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        Arrays.sort(c1); Arrays.sort(c2);
        if (!Arrays.equals(c1, c2)) return false;
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))
                return true;
        }
        return false;
    }
    
    /**
     * DP
     */
    public boolean isScramble2(String s1, String s2) {
        int n = s1.length();
        // 表示 s1[i ~ i + k - 1] 与 s2[j, j + k - 1] 所有匹配的集合是否非空，区间 dp
        boolean[][][] dp = new boolean[n][n][n + 1];
        // 先枚举区间长度
        for (int k = 1; k <= n; k++) {
            // 遍历第一个串的右端点，第一个串的右端点不可以越界
            for (int i = 0; i + k - 1 < n; i++) {
                // 遍历第二个串的右端点，第二个串的右端点不可以越界
                for (int j = 0; j + k - 1 < n; j++) {
                    // 若为 1 则仅需要判断两个字符是否想等即可
                    if (k == 1) {
                        if (s1.charAt(i) == s2.charAt(j)) {
                            dp[i][j][k] = true;
                        }
                    }
                    else {
                        // 枚举分节点
                        // 状态计算：将 f[i, j, k] 表示的集合按 s1 第一段的长度划分划分成 k - 1 类，设 s1 第一段的长度为 u。
                        // 则 s1[i ~ i + k - 1] 与 s2[j, j + k - 1] 有两种匹配方案，分别对应题目中字符串长度 >1 后的两种步骤，
                        // 分别判断即可（两种步骤是或的关系，有一种满足就行）
                        for (int u = 1; u < k; u++) {
                            if (dp[i][j][u] && dp[i + u][j + u][k - u] || dp[i][j + k - u][u] && dp[i + u][j][k - u]) {
                                dp[i][j][k] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
    
}
