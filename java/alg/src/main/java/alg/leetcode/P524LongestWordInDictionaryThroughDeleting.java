package alg.leetcode;

import java.util.List;

/**
 * @link https://leetcode.cn/problems/longest-word-in-dictionary-through-deleting/
 * @author zhangxq
 * @since 2023/9/25
 */
public class P524LongestWordInDictionaryThroughDeleting {
    
    public static void main(String[] args) {
    
    }
    
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (var str : dictionary) {
            if (check(str, s)) {
                if (res.isBlank()
                        || res.length() < str.length()
                        || res.length() == str.length() && res.compareTo(str) > 0) {
                    res = str;
                }
            }
        }
        return res;
    }
    // 判断 b 是不是 a 的子序列
    private boolean check(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) i++;
            j++;
        }
        return i == a.length();
    }
}
