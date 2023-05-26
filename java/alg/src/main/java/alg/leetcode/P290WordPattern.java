package alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @link https://leetcode.cn/problems/word-pattern/
 * @author zhangxq
 * @since 2023/5/26
 */
public class P290WordPattern {
    
    public static void main(String[] args) {
        P290WordPattern solution = new P290WordPattern();
        solution.wordPattern("abba", "dog cat cat dog");
    }
    
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> reverse = new HashMap<>();
        String[] sarr = s.split(" ");
        if (pattern.length() != sarr.length) return false;
        int n = pattern.length();
        for (int i = 0; i < n; i++) {
            char c = pattern.charAt(i);
            String str = sarr[i];
            if (map.containsKey(c) && reverse.containsKey(str)) {
                if (!map.get(c).equals(str) || c != reverse.get(str)) return false;
            }
            else if (map.containsKey(c) || reverse.containsKey(str)) {
                return false;
            }
            map.put(c, str);
            reverse.put(str, c);
        }
        return true;
    }
}
