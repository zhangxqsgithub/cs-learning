package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/largest-palindrome-product/
 * @author zhangxq
 * @since 2023/9/11
 */
public class P479LargestPalindromeProduct {
    
    public static void main(String[] args) {
    
    }
    
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        // 枚举回文数
        var maxv = (int) Math.pow(10, n) - 1; // n 位数的最大值
        for (int i = maxv; i >= 0; i--) {
            var a = String.valueOf(i);
            var b = new StringBuilder(a).reverse().toString();
            var num = Long.parseLong(a + b);
            for (long j = maxv; j * j >= num; j--)
                if (num % j == 0)
                    return (int) (num % 1337);
        }
        return 0;
    }
}
