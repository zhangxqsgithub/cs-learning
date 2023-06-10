package alg.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/number-of-segments-in-a-string/
 * @author zhangxq
 * @since 2023/6/10
 */
public class P434NumberOfSegmentsInAString {
    
    public static void main(String[] args) {
        var s = "    foo    bar";
        var arr = s.trim().split("\\s+");
        System.out.println(Arrays.toString(arr));
    }
    
    public int countSegments(String s) {
        // if (s.isBlank()) return 0;
        // else return s.split("^ +").length;
        int res = 0;
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == ' ') { i++; continue; }
            while (i < s.length() && s.charAt(i) != ' ') i++;
            res++;
        }
        return res;
    }
}
