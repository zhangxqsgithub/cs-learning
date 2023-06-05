package alg.leetcode;

import java.util.HashMap;

/**
 * @link https://leetcode.cn/problems/ransom-note/
 * @author zhangxq
 * @since 2023/6/5
 */
public class P383RansomNote {
    
    public static void main(String[] args) {
    
    }
    
    public boolean canConstruct(String ransomNote, String magazine) {
        var map = new HashMap<Character, Integer>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            }
            else return false;
        }
        return false;
    }
}
