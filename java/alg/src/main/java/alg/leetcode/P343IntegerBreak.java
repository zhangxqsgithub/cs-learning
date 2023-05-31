package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/integer-break/
 * @author zhangxq
 * @since 2023/5/31
 */
public class P343IntegerBreak {
    
    public static void main(String[] args) {
    
    }
    
    // 尽可能分成 3、2，2 的个数最多有两个
    public int integerBreak(int n) {
        if (n <= 3) return 1 * (n - 1);
        int p = 1;
        while (n >= 5) {
            n -= 3;
            p *= 3;
        }
        return p * n;
    }
}
