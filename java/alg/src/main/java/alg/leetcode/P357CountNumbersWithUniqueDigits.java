package alg.leetcode;

import java.util.List;

/**
 * @link https://leetcode.cn/problems/count-numbers-with-unique-digits/
 * @author zhangxq
 * @since 2023/6/1
 */
public class P357CountNumbersWithUniqueDigits {
    
    public static void main(String[] args) {
    
    }
    
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int[] f = new int[n + 1];
        f[1] = 9;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] * (11 - i);
        }
        int res = 1;
        for (int i = 1; i <= n; i++) res += f[i];
        return res;
    }
}
