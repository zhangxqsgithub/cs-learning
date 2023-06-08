package alg.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @link https://leetcode.cn/problems/frog-jump/
 * @author zhangxq
 * @since 2023/6/8
 */
public class P403FrogJump {
    
    public static void main(String[] args) {
    
    }
    
    int[] stones;
    int N = 2010;
    int[][] dp = new int[N][N];
    Map<Integer, Integer> map = new HashMap<>();
    public boolean canCross(int[] stones) {
        this.stones = stones;
        int n = stones.length;
        for (int i = 0; i < n; i++) map.put(stones[i], i);
        for (int i = 0; i < N; i++) Arrays.fill(dp[i], -1);
        dp[0][1] = 1;
        for (int i = 0; i <= n; i++)
            if (f(n - 1, i))
                return true;
        return false;
    }
    public boolean f(int i, int j) {
        if (dp[i][j] != -1) return dp[i][j] != 0;
        dp[i][j] = 0;
        for (int l = Math.max(1, j - 1); l <= j + 1; l++) {
            int x = stones[i] - l;
            if (map.containsKey(x)) {
                int k = map.get(x);
                if (f(k, l)) {
                    dp[i][j] = 1;
                    break;
                }
            }
        }
        return dp[i][j] != 0;
    }
}
