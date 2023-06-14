package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/repeated-substring-pattern/
 * @author zhangxq
 * @since 2023/6/14
 */
public class P459RepeatedSubstringPattern {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 求字符串周期是 KMP 的一个经典用法
     */
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        s = " " + s;
        var next = new int[n + 1]; // next 数组
        for (int i = 2, j = 0; i <= n; i++) {
            while (j != 0 && s.charAt(i) != s.charAt(j + 1)) j = next[j];
            if (s.charAt(i) == s.charAt(j + 1)) j++;
            next[i] = j;
        }
        int t = n - next[n];
        return t < n && n % t == 0;
    }
}
