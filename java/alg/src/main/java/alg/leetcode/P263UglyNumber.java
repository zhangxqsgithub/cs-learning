package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/ugly-number/
 * @author zhangxq
 * @since 2023/5/25
 */
public class P263UglyNumber {
    
    public static void main(String[] args) {
    
    }
    
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        return n == 1;
    }
}
