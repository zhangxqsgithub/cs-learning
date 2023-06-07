package alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @link https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/
 * @author zhangxq
 * @since 2023/6/6
 */
public class P395LongestSubstringWithAtLeastKRepeatingCharacters {

    public static void main(String[] args) {

    }
    
    /**
     * 枚举区间中最多包含的不同字符的数量
     */
    int k;
    Map<Character, Integer> cnt;
    int x; int y; // x 表示不同字符的数量，满足出现 >= k 次的要求的字符数量
    public int longestSubstring(String s, int k) {
        this.k = k;
        this.cnt = new HashMap<>();
        int res = 0;
        for (int l = 1; l <= 26; l++) {
            cnt.clear(); // 每次枚举前需要将 hash 表清空
            this.x = 0; this.y = 0;
            for (int i = 0, j = 0; i < s.length(); i++) {
                add(s.charAt(i));
                while (x > l) del(s.charAt(j++));
                if (x == y) res = Math.max(res, i - j + 1);
            }
        }
        return res;
    }
    public void add(char c) {
        if (!cnt.containsKey(c)) {
            cnt.put(c, 0);
            x++;
        }
        cnt.put(c, cnt.get(c) + 1);
        if (cnt.get(c) == k) y++; // 有一种新字符满足要求
    }
    public void del(char c) {
        if (cnt.containsKey(c)) {
            if (cnt.get(c) == k) y--;
            cnt.put(c, cnt.get(c) - 1);
            if (cnt.get(c) == 0) x--; // 说明有一种字符消失了
        }
    }
}
