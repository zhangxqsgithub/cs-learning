package alg.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @link https://leetcode.cn/problems/reverse-vowels-of-a-string/
 * @author zhangxq
 * @since 2023/5/31
 */
public class P345ReverseVowelsOfAString {
    
    public static void main(String[] args) {
        var solution = new P345ReverseVowelsOfAString();
        String res = solution.reverseVowels("hello");
        System.out.println(res);
    }
    
    public String reverseVowels(String s) {
        var set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        var c = s.toCharArray();
        int i = 0, j = c.length - 1;
        while (i < j) {
            while (i < c.length && !set.contains(c[i])) i++;
            while (j >= 0 && !set.contains(c[j])) j--;
            if (i < j) {
                var t = c[i]; c[i] = c[j]; c[j] = t;
            }
            i++; j--;
        }
        return String.valueOf(c);
    }
}
