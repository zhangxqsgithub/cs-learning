package alg.acwing_course.algbase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxq
 * @since 2023/6/29
 */
public class C2_02KMP {
    
    public static void main(String[] args) {
    
    }
    
    public int[] next(String p) {
        var next = new int[p.length()];
        for (int i = 1, j = 0; i < p.length(); i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) j = next[j - 1];
            if (p.charAt(i) == p.charAt(j)) j++;
            next[i] = j;
        }
        return next;
    }
    
    public List<Integer> kmp(String s, String p) {
        var res = new ArrayList<Integer>();
        var next = next(p);
        for (int i = 0, j = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) j = next[j - 1];
            if (s.charAt(i) == p.charAt(j)) j++;
            if (j == p.length()) {
                j = next[j - 1];
                
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
}
