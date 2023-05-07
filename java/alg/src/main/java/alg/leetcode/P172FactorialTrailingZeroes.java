package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/factorial-trailing-zeroes/
 * @author zhangxq
 * @since 2023/5/7
 */
public class P172FactorialTrailingZeroes {
    
    public static void main(String[] args) {
    
    }
    
    public int trailingZeroes(int n) {
        var res = 0;
        while (n > 0) { res += n / 5; n /= 5; }
        return res;
    }
}
