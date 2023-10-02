package alg.leetcode;

import java.util.ArrayList;

/**
 * @link https://leetcode.cn/problems/non-negative-integers-without-consecutive-ones/
 * @author zhangxq
 * @since 2023/10/2
 */
public class P600NonNegativeIntegersWithoutConsecutiveOnes {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 数位 DP
     */
    public int findIntegers(int n) {
        var num = new ArrayList<Integer>();
        while (n > 0) { num.add(n % 2); n /= 2; }
        // 状态转移数组
        var dp = new int[num.size() + 1][2];
        // 若只有一位，填 0 填 1 都是合法的
        dp[1][0] = dp[1][1] = 1;
        for (int i = 2; i <= num.size(); i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }
        
        int res = 0;
        for (int i = num.size(), last = 0; i > 0; i--) {
            int x = num.get(i - 1);
            if (x == 1) {
                res += dp[i][0];
                // 上一个值也是 1
                if (last == 1) return res;
            }
            last = x;
        }
        return res + 1;
    }
}

