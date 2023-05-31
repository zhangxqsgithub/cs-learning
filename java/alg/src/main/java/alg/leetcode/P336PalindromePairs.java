package alg.leetcode;

import java.util.*;

/**
 * @link https://leetcode.cn/problems/palindrome-pairs/
 * @author zhangxq
 * @since 2023/5/31
 */
public class P336PalindromePairs {
    
    public static void main(String[] args) {
        var solution = new P336PalindromePairs();
        var words = new String[]{"a",""};
        var res = solution.palindromePairs(words);
        System.out.println(res);
    }
    
    /**
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i< words.length; i++) map.put(reverse(words[i]), i);
        
        for (int i = 0; i < words.length; i++) {
            var w = words[i];
            StringBuilder l = new StringBuilder();
            StringBuilder r = new StringBuilder(w);
            for (int j = 0; j <= w.length(); j++) {
                if (check(r.toString()) && map.containsKey(l.toString()) && map.get(l.toString()) != i) {
                    res.add(Arrays.asList(i, map.get(l.toString())));
                }
                if (check(l.toString()) && map.containsKey(r.toString()) && map.get(r.toString()) != i && w.length() != words[map.get(r.toString())].length()) {
                    res.add(Arrays.asList(map.get(r.toString()), i));
                }
                if (j < w.length()) {
                    l.append(w.charAt(j));
                    r.deleteCharAt(0);
                }
            }
        }
        return res;
    }
    public boolean check(String str) {
        for (int i = 0, j = str.length() - 1; i < j; i++, j--)
            if (str.charAt(i) != str.charAt(j))
                return false;
        return true;
    }
    public String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
