package alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @link https://leetcode.cn/problems/longest-repeating-character-replacement/
 * @author zhangxq
 * @since 2023/6/9
 */
public class P424LongestRepeatingCharacterReplacement {
    
    public static void main(String[] args) {
    
    }
    
    public int characterReplacement(String s, int k) {
        int res = 0;
        int maxNum = 0;
        var map = new HashMap<Character, Integer>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > maxNum) maxNum = map.get(c);
            while (j - i + 1 - maxNum > k) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                maxNum = Math.max(map.get(s.charAt(i)), maxNum);
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
