package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/beautiful-arrangement/
 * @author zhangxq
 * @since 2023/9/25
 */
public class P526BeautifulArrangement {
    
    public static void main(String[] args) {
    
    }
    
    public int countArrangement(int n) {
        var dp = new int[1 << n];
        dp[0] = 1;
        for (int i = 0; i < 1 << n; i++) {
            // 记录当前有几位
            int k = 0;
            for (int j = 0; j < n; j++)
                if ((i >> j & 1) == 1)
                    k++;
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 0) {
                    if ((k + 1) % (j + 1) == 0 || (j + 1) % (k + 1) == 0) {
                        dp[i | (1 << j)] += dp[i];
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}
