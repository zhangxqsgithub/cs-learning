package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/nth-digit/
 * @author zhangxq
 * @since 2023/6/8
 */
public class P400NthDigit {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 计算 n 有几位数
     * 计算 n 是 k 位数的第几个数
     */
    public int findNthDigit(int n) {
        // k 表示位数，t 表示每位有几个数，s 表示 k 位数的第一个数是多少
        long k = 1, t = 9, s = 1;
        while (n > k * t) {
            n -= k * t;
            k++;
            t *= 10; // 下一位的数的个数
            s *= 10;
        }
        // n 是第几个 k 位数，即 ⎡n/k⎤ = ⎣(n + k - 1) / k⎦
        s += (n + k - 1) / k - 1;
        n = (int) (n % k != 0 ? n % k : k);
        return String.valueOf(s).charAt(n - 1) - '0';
    }
}
