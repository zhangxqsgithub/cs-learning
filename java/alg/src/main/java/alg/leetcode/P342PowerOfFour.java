package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/power-of-four/
 * @author zhangxq
 * @since 2023/5/31
 */
public class P342PowerOfFour {
    
    public static void main(String[] args) {
    
    }
    
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        int t = (int) Math.sqrt(n);
        return t * t == n && (1 << 30) % n == 0;
    }
}
