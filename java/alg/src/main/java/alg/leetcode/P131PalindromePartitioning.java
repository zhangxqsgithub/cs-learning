package alg.leetcode;

import java.util.*;

/**
 * @link https://leetcode.cn/problems/palindrome-partitioning/
 * @author zhangxq
 * @since 2023/4/27
 */
public class P131PalindromePartitioning {
    
    public static void main(String[] args) {
    
    }
    
    boolean[][] f;
    List<List<String>> ans = new ArrayList<>();
    Deque<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        int n = s.length();
        f = new boolean[n][n];
        for (int j = 0; j < n; j++)
            // 预处理 f 数组，记录 (i, j) 这一段子串是不是回文串
            // 根据递推公式 f[i][j] = (i + 1 > j - 1 || f[i + 1][j - 1]) && s[i] == s[j]（i <= j）i + 1 > j - 1 表示只有两个字符的情况
            // 得到应该先从小到大遍历 j，再从小到大遍历 i，可以理解为优先算每一个较小的 j 全算出来了之后
            for (int i = 0; i <= j; i++) {
                if (i == j) f[i][j] = true;
                else if (s.charAt(i) == s.charAt(j))
                    // i + 1 > j - 1 表示只有两个字符的情况
                    f[i][j] = i + 1 > j - 1 || f[i + 1][j - 1];
            }
        dfs(s, 0);
        return ans;
    }
    public void dfs(String s, int u) {
        if (u == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = u; i < s.length(); i++)
            if (f[u][i]) {
                path.add(s.substring(u, i + 1));
                dfs(s, i + 1);
                path.removeLast();
            }
    }
}
