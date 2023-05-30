package alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @link https://leetcode.cn/problems/remove-duplicate-letters/
 * @author zhangxq
 * @since 2023/5/30
 */
public class P316RemoveDuplicateLetters {
    
    public static void main(String[] args) {
    
    }
    
    public String removeDuplicateLetters(String s) {
        StringBuilder stk = new StringBuilder();
        Map<Character, Boolean> ins = new HashMap<>();
        // 记录每个字母最后一次出现的位置
        Map<Character, Integer> last = new HashMap<>();
        for (int i = 0; i < s.length(); i++) last.put(s.charAt(i), i);
        
        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            // 如果当前字母已经在栈里了
            if (ins.containsKey(c) && ins.get(c)) continue;
            while (stk.length() != 0 && stk.charAt(stk.length() - 1) > c && last.get(stk.charAt(stk.length() - 1)) > i) {
                ins.put(stk.charAt(stk.length() - 1), false);
                stk.deleteCharAt(stk.length() - 1);
            }
            stk.append(c);
            ins.put(c, true);
        }
        return stk.toString();
    }
    
}
