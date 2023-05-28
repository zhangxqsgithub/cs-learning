package alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @link https://leetcode.cn/problems/bulls-and-cows/
 * @author zhangxq
 * @since 2023/5/27
 */
public class P299BullsAndCows {
    
    public static void main(String[] args) {
    
    }
    
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : secret.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        int tot = 0;
        for (char c : guess.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                tot++;
                map.put(c, map.get(c) - 1);
            }
        }
        int bulls = 0;
        for (int i = 0; i < secret.length(); i++)
            if (secret.charAt(i) == guess.charAt(i))
                bulls++;
        return bulls + "A" + (tot - bulls) + "B";
    }
}
