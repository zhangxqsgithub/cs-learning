package alg.leetcode;

import java.util.List;

/**
 * @author will
 * @link https://leetcode.cn/problems/shopping-offers/
 * @since 2024/3/25
 */
public class P638ShoppingOffers {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 完全背包问题
     */
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        var n = price.size();
        var g = new int[n + 1];
        g[0] = 1;
        for (int i = 1; i <= n; i++) g[i] = g[i - 1] * (needs.get(i - 1) + 1);
        var dp = new int[g[n]];
        for (int i = 1; i < g[n]; i++) {
            dp[i] = (int) 1e9;
            var cnt = new int[n];
            for (int j = 0; j < n; j++) cnt[j] = i % g[j + 1] / g[j];
            for (int j = 0; j < n; j++) {
                if (cnt[j] > 0) dp[i] = Math.min(dp[i], dp[i - g[j]] + price.get(j));
            }
            for (int j = 0; j < special.size(); j++) {
                var flag = true;
                var cur = i;
                for (int k = 0; k < n; k++) {
                    if (cnt[k] < special.get(j).get(k)) {
                        flag = false;
                        break;
                    }
                    else {
                        cur -= g[k] * special.get(j).get(k);
                    }
                }
                if (flag) {
                    dp[i] = Math.min(dp[i], dp[cur] + special.get(j).get(n));
                }
            }
        }
        return dp[g[n] - 1];
    }
}
