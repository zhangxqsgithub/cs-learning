package alg.leetcode;

import java.math.BigInteger;

/**
 * @link https://leetcode.cn/problems/next-greater-element-iii/
 * @author zhangxq
 * @since 2023/9/28
 */
public class P556NextGreaterElementIII {
    
    public static void main(String[] args) {
        var solution = new P556NextGreaterElementIII();
        var res1 = solution.nextGreaterElement(230241);
        System.out.println(res1);
    }
    
    public int nextGreaterElement(int num) {
        var s = String.valueOf(num).toCharArray();
        // 找到第一个升序的位置
        int k = s.length - 1;
        while (k > 0 && s[k - 1] >= s[k]) k--;
        if (k == 0) return -1;
        // [k, n) 中找到一个 > s[k - 1] 的最小值
        int t = k;
        while (t + 1 < s.length && s[t + 1] > s[k - 1]) t++;
        // swap(k - 1, t)
        var tmp = s[k - 1]; s[k - 1] = s[t]; s[t] = tmp;
        // reverse(k, n - 1)
        int i = k, j = s.length - 1;
        while (i < j) { var _t = s[i]; s[i] = s[j]; s[j] = _t; i++; j--; }
        long res = Long.parseLong(String.valueOf(s));
        if (res > Integer.MAX_VALUE) return -1;
        return (int) res;
    }
    
    /**
     * 暴力
     * 比当前一位大的最小的数，与之交换
     */
    public int nextGreaterElement2(int n) {
        var s = String.valueOf(n).toCharArray();
        for (int i = s.length - 1; i > 0; i--) {
            if (s[i] - '0' > s[i - 1] - '0') {
                // swap(i, i - 1)
                var t = s[i]; s[i] = s[i - 1]; s[i - 1] = t;
                var num = Long.parseLong(String.valueOf(s));
                if (num > Integer.MAX_VALUE) return -1;
                else return (int) num;
            }
        }
        return -1;
    }
    
}
