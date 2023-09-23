package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/longest-uncommon-subsequence-i/
 * @author zhangxq
 * @since 2023/9/23
 */
public class P521LongestUncommonSubsequenceI {
    
    public static void main(String[] args) {
    
    }
    
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;
        return Math.max(a.length(), b.length());
    }
}
