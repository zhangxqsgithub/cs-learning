package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/longest-uncommon-subsequence-ii/
 * @author zhangxq
 * @since 2023/9/23
 */
public class P522LongestUncommonSubsequenceII {
    
    public static void main(String[] args) {
    
    }
    
    public int findLUSlength(String[] strs) {
        var res = -1;
        for (int i = 0; i < strs.length; i++) {
            var success = true;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && check(strs[i], strs[j])) {
                    success = false;
                    break;
                }
            }
            if (success) {
                res = Math.max(res, strs[i].length());
            }
        }
        return res;
    }
    private boolean check(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) i++;
            j++;
        }
        return i == a.length();
    }
}
