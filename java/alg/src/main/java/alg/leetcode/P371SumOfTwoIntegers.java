package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/sum-of-two-integers/
 * @author zhangxq
 * @since 2023/6/2
 */
public class P371SumOfTwoIntegers {
    
    public static void main(String[] args) {
    
    }
    
    public int getSum(int a, int b) {
        if (b == 0) return a;
        int sum = a ^ b, carry = (a & b) << 1; // a + b => ((a & b) >> 1) + (a ^ b)
        return getSum(sum, carry);
    }
}
