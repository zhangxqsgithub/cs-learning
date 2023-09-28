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
    
    public int nextGreaterElement(int n) {
        var s = String.valueOf(n).toCharArray();
        for (int i = s.length - 1; i > 0; i--) {
            if (s[i] - '0' > s[i - 1] - '0') {
                // 找到比 s[i - 1] 大的最小的值
                int j = i;
                while (j + 1 < s.length && s[j + 1] - '0' > s[i - 1] - '0') j++;
                var t = s[i - 1]; s[i - 1] = s[j]; s[j] = t;
                // 将后面的序列反转一遍
                reverse(s, i, s.length - 1);
                var num = Long.parseLong(String.valueOf(s));
                if (num > Integer.MAX_VALUE) return -1;
                else return (int) num;
            }
        }
        return -1;
    }
    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            var t = arr[i]; arr[i] = arr[j]; arr[j] = t;
            i++; j--;
        }
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
