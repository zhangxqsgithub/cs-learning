package alg.leetcode;

import java.util.HashMap;

/**
 * @link https://leetcode.cn/problems/unique-substrings-in-wraparound-string/
 * @author zhangxq
 * @since 2023/6/15
 */
public class P467UniqueSubstringsInWraparoundString {
    
    public static void main(String[] args) {
    
    }
    
    public int findSubstringInWraproundString(String s) {
        var cnt = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length();) {
            int j = i + 1;
            while (j < s.length() && (s.charAt(j) - s.charAt(j - 1) == 1 || s.charAt(j) == 'a' && s.charAt(j - 1) == 'z')) {
                j++;
            }
            while (i < j) {
                cnt.put(s.charAt(i), Math.max(cnt.getOrDefault(s.charAt(i), 0), j - i));
                i++;
            }
        }
        int res = 0;
        for (var e : cnt.entrySet()) res += e.getValue();
        return res;
    }
}
