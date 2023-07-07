package alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangxq
 * @since 2023/6/27
 */
public class KMPSearch {
    
    public static void main(String[] args) {
        var solution = new KMPSearch();
        var s = "ABABCABAA";
        var next = solution.next(s.toCharArray());
        System.out.println(Arrays.toString(next));
    }
    
    // 构造模式串 pattern 的最大匹配数表
    public int[] next(String p) {
        int[] next = new int[p.length()];
        for (int i = 1, j = 0; i < p.length(); i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) j = next[j - 1];
            if (p.charAt(i) == p.charAt(j)) j++;
            next[i] = j;
        }
        return next;
    }
    
    public int[] next(char[] p) {
        var n = p.length;
        var next = new int[n];
        for (int i = 1, cnt = 0; i < n; i++) {
            while (cnt != 0 && p[i] != p[cnt]) cnt = next[cnt - 1];
            if (p[i] == p[cnt]) cnt++;
            next[i] = cnt;
        }
        return next;
    }
    
    public List<Integer> kmp(String s, String p) {
        var positions = new ArrayList<Integer>();
        int[] next = next(p);
        for (int i = 0, j = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) j = next[j - 1];
            if (s.charAt(i) == p.charAt(j)) j++;
            if (j == p.length()) {
                j = next[j - 1];
                positions.add(i - p.length() + 1);
            }
        }
        return positions;
    }
    
    // next 数组
    public int[] next2(String p) {
        int[] next = new int[p.length() + 1];
        for (int i = 2, j = 0; i <= p.length(); i++) {
            // i 要和 j + 1 匹配
            while (j > 0 && p.charAt(i) != p.charAt(j + 1)) j = next[j];
            if (p.charAt(i) == p.charAt(j + 1)) j++;
            next[i] = j;
        }
        return next;
    }
    
    public List<Integer> kmp2(String s, String p) {
        var res = new ArrayList<Integer>();
        int[] next = next(p);
        for (int i = 1, j = 0; i <= s.length(); i++) {
            // j 没有回到起点，并且 s[i] != p[j + 1]
            while (j != 0 && s.charAt(i) != p.charAt(j + 1)) j = next[j];
            if (s.charAt(i) == p.charAt(j + 1)) j++;
            if (j == p.length()) {
                j = next[j];
                
                // 匹配成功后的逻辑
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
}
