package alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @link https://leetcode.cn/problems/find-the-difference/
 * @author zhangxq
 * @since 2023/6/6
 */
public class P389FindTheDifference {
    
    public static void main(String[] args) {
    
    }
    
    public char findTheDifference(String s, String t) {
        var map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return c;
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) map.remove(c);
        }
        return map.keySet().iterator().next();
    }
    
    public char findTheDifference2(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int n = c1.length;
        char res = c2[n];
        for (int i = 0; i < n; i++) {
            res ^= c1[i];
            res ^= c2[i];
        }
        return res;
    }
    
    public char findTheDifference3(String s, String t) {
        int a = 0, b = 0;
        for (char c : s.toCharArray()) a += c;
        for (char c : t.toCharArray()) b += c;
        return (char) (b - a);
    }
}
