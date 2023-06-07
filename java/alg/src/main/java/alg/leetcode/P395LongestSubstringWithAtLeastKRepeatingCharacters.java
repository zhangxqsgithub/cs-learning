package alg.leetcode;

import java.util.Arrays;
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
    
    public int longestSubstring2(String s, int k) {
        int res = 0;
        int[] cnt = new int[26];
        for (int u = 1; u <= 26; u++) {
            Arrays.fill(cnt, 0);
            int charCnt = 0;
            int qualified = 0;
            for (int i = 0, j = 0; i < s.length(); i++) {
                int id = s.charAt(i) - 'a';
                cnt[id]++;
                if (cnt[id] == 1) {
                    charCnt++;
                }
                if (cnt[id] == k) {
                    qualified++;
                }
                while (j < i && charCnt > u) {
                    id = s.charAt(j++) - 'a';
                    cnt[id]--;
                    if (cnt[id] == 0) {
                        charCnt--;
                    }
                    if (cnt[id] == k - 1) {
                        qualified--;
                    }
                }
                if (charCnt == u && qualified == u) {
                    res = Math.max(res, i - j + 1);
                }
            }
        }
        return res;
    }
}
