package alg.leetcode;

import java.util.*;

/**
 * @link https://leetcode.cn/problems/keyboard-row/
 * @author zhangxq
 * @since 2023/9/14
 */
public class P500KeyboardRow {
    
    public static void main(String[] args) {
        var solution = new P500KeyboardRow();
        var res1 = solution.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        System.out.println(Arrays.toString(res1));
    }
    
    Map<Character, Integer> map = new HashMap<>(){{
        put('q', 0);put('w', 0);put('e', 0);put('r', 0);put('t', 0);put('y', 0);put('u', 0);put('i', 0);put('o', 0);put('p', 0);
        put('a', 1);put('s', 1);put('d', 1);put('f', 1);put('g', 1);put('h', 1);put('j', 1);put('k', 1);put('l', 1);
        put('z', 2);put('x', 2);put('c', 2);put('v', 2);put('b', 2);put('n', 2);put('m', 2);
    }};
    public String[] findWords(String[] words) {
        var list = new ArrayList<String>();
        for (var w : words) {
            var set = new HashSet<Integer>();
            for (var c : w.toCharArray()) {
                set.add(map.get(Character.toLowerCase(c)));
            }
            if (set.size() == 1) {
                list.add(w);
            }
        }
        return list.toArray(new String[0]);
    }
}
