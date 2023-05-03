package alg.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/candy/
 * @author zhangxq
 * @since 2023/5/3
 */
public class P135Candy {
    
    public static void main(String[] args) {
    
    }
    
    int n;
    int[] f, w;
    public int candy(int[] ratings) {
        n = ratings.length;
        f = new int[n];
        Arrays.fill(f, -1);
        w = ratings;
        var res = 0;
        for (var i = 0; i < n; i++) res += dp(i);
        return res;
    }
    public int dp(int x) {
        if (f[x] != -1) return f[x];
        f[x] = 1;
        if (x - 1 >= 0 && w[x - 1] < w[x]) f[x] = Math.max(f[x], dp(x - 1) + 1);
        if (x + 1 <  n && w[x + 1] < w[x]) f[x] = Math.max(f[x], dp(x + 1) + 1);
        return f[x];
    }
}
