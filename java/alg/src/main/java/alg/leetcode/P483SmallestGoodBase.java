package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/smallest-good-base/
 * @author zhangxq
 * @since 2023/9/11
 */
public class P483SmallestGoodBase {
    
    public static void main(String[] args) {
    
    }
    
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        for (int t = (int) log2(num) + 1; t >= 3; t--) {
            long k = (long) Math.pow(num, 1.0 / (t - 1));
            long r = 0;
            // 求解 t 是不是一个答案
            for (int i = 0; i < t; i++) r = r * k + 1;
            if (r == num) return String.valueOf(k);
        }
        return String.valueOf(num - 1);
    }
    
    public static double log2(long x) {
        return Math.log(x) / Math.log(2);
    }
}
