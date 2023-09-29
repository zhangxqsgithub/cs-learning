package alg.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @link https://leetcode.cn/problems/permutation-in-string/
 * @author zhangxq
 * @since 2023/9/29
 */
public class P567PermutationInString {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 滑动窗口问题
     */
    Map<Character, Integer> S1 = new HashMap<>();
    Map<Character, Integer> S2 = new HashMap<>();
    public boolean checkInclusion(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            S1.put(c, S1.getOrDefault(c, 0) + 1);
        }
        for (int i = 0, j = 0, cnt = 0; i < s2.length(); i++) {
            var c = s2.charAt(i);
            if (check(c)) cnt--;
            S2.put(c, S2.getOrDefault(c, 0) + 1);
            if (check(c)) cnt++;
            
            if (i - j >= s1.length()) {
                var jc = s2.charAt(j);
                if (check(jc)) cnt--;
                S2.put(jc, S2.getOrDefault(jc, 0) - 1);
                if (check(jc)) cnt++;
                j++;
            }
            
            if (cnt == S1.size()) return true;
        }
        return false;
    }
    private boolean check(char c) {
        return S1.containsKey(c) && S2.containsKey(c) && S1.get(c).equals(S2.get(c));
    }
}
