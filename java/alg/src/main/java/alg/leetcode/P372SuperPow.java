package alg.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/super-pow/
 * @author zhangxq
 * @since 2023/6/2
 */
public class P372SuperPow {
    
    public static void main(String[] args) {
    
    }
    
    // 返回 (a的b次方) % 1337
    // 快速幂
    int mod = 1337;
    public int superPow(int a, int[] b) {
        if (b.length == 0) return 1;
        a %= mod;
        int x = b[b.length - 1];
        int[] newb = Arrays.copyOf(b, b.length - 1);
        return qmi(a, x) * qmi(superPow(a, newb), 10) % mod;
    }
    public int qmi(int a, int b) {
        int res = 1;
        while (b != 0) {
            if ((b & 1) != 0) res = res * a % mod;
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
}
