package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/is-subsequence/
 * @author zhangxq
 * @since 2023/6/6
 */
public class P392IsSubsequence {
    
    public static void main(String[] args) {
    
    }
    
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            char c1 = s.charAt(i), c2 = t.charAt(j);
            if (c1 == c2) i++;
            j++;
        }
        return i == s.length();
    }
}
