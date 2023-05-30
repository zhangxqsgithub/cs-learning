package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/power-of-three/
 * @author zhangxq
 * @since 2023/5/30
 */
public class P326PowerOfThree {
    
    public static void main(String[] args) {
    
    }
    
    public boolean isPowerOfThree(int n) {
        // 3 ^ 19
        return n > 0 && 1_162_261_467 % n == 0;
    }
}
