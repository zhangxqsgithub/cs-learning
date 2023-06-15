package alg.leetcode;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @link https://leetcode.cn/problems/can-i-win/
 * @author zhangxq
 * @since 2023/6/15
 */
public class P464CanIWin {
    
    public static void main(String[] args) {
    
    }
    
    int[] dp;
    int n;
    int m;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // 一定赢不了
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        // 先手的人，若在没有报的数字中存在一个数，使得选择这个数之后，两数相加 >= desiredTotal 的话，则必胜。
        n = maxChoosableInteger;
        m = desiredTotal;
        dp = new int[1 << maxChoosableInteger];
        Arrays.fill(dp, -1);
        return f(0) != 0;
    }
    
    public int f(int x) {
        if (dp[x] != -1) return dp[x];
        int sum = 0;
        for (int i = 0; i < n; i++)
            if ((x >> i & 1) == 1)
                sum += i + 1;
        // 枚举当前的所有转移
        for (int i = 0; i < n; i++) {
            if ((x >> i & 1) == 1) continue;
            if (sum + i + 1 >= m) { // 必胜
                dp[x] = 1;
                return dp[x];
            }
            if (f(x + (1 << i)) == 0) { // 对手必败
                dp[x] = 1;
                return dp[x];
            }
        }
        // 若任何一种情况都必败，则我们必败
        dp[x] = 0;
        return dp[x];
    }
}
