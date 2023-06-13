package alg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/sort-characters-by-frequency/
 * @since 2023/6/13
 */
public class P451SortCharactersByFrequency {
    
    public static void main(String[] args) {
    
    }
    
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        var list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) == map.get(a) ? a - b : map.get(b) - map.get(a));
        var sb = new StringBuilder();
        for (char c : list) {
            sb.append(String.valueOf(c).repeat(Math.max(0, map.get(c))));
        }
        return sb.toString();
    }
    
}
