package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/sum-of-square-numbers/
 * @author will
 * @since 2024/3/25
 */
public class P633SumOfSquareNumbers {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 枚举从 1 - 根下c
     * 费马平方和定理
     */
    public boolean judgeSquareSum(int c) {
        for (long i = 0; i * i <= c; i++) {
            int j = c - (int) (i * i);
            int r = (int) Math.sqrt(j);
            if (r * r == j) return true;
        }
        return false;
    }
}
