package alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 *
 * @author zhangxq
 * @link https://leetcode.cn/problems/minimum-window-substring/
 * @since 2023/1/15
 */
public class P76MinimumWindowSubstring {
    
    public static void main(String[] args) {
    
    }
    
    public String minWindow(String s, String t) {
        Map<Character, Integer> hs = new HashMap<>();
        Map<Character, Integer> ht = new HashMap<>();
        // 初始化T串中字符出现次数
        for (int i = 0; i < t.length(); i++) {
            ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i), 0) + 1);
        }
        String res = "";
        int cnt = 0; // 用来统计有效字符的数量
        // 枚举每一个终点
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hs.put(c, hs.getOrDefault(c, 0) + 1);
            if (ht.containsKey(c) && hs.get(c) <= ht.get(c)) cnt++;
            // 判断 j 是不是合法的
            while (j <= i && (!ht.containsKey(s.charAt(j)) || hs.get(s.charAt(j)) > ht.get(s.charAt(j)))) {
                hs.put(s.charAt(j), hs.get(s.charAt(j++)) - 1);
            }
            // 有效窗口
            if (cnt == t.length()) {
                if (res.isEmpty() || (i - j + 1) < res.length()) {
                    res = s.substring(j, i + 1);
                }
            }
        }
        return res;
    }
    
}
