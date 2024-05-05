package alg.acwing_course.base;

import java.util.ArrayList;
import java.util.List;

/**
 * KMP 算法
 * @author zhangxq
 * @since 2023/6/29
 */
public class C207KMP {
    
    public static void main(String[] args) {
        var solution = new C207KMP();
        var res1 = solution.search("BBC ABCDAB ABCDABCDABDE", "ABCDABD");
        System.out.println(res1);
        
        var res2 = solution.kmp("BBC ABCDAB ABCDABCDABDE", "ABCDABD");
        System.out.println(res2);
    }
    
    /**
     * 暴力搜索
     */
    public List<Integer> search(String s, String p) {
        int n = s.length(), m = p.length();
        var res = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (j < m && s.charAt(i + j) == p.charAt(j)) j++;
            if (j == m) res.add(i);
        }
        return res;
    }
    
    public List<Integer> kmp(String s, String p) {
        var res = new ArrayList<Integer>();
        var next = next(p);
        for (int i = 0, j = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) j = next[j - 1];
            if (s.charAt(i) == p.charAt(j)) j++;
            // 匹配成功
            if (j == p.length()) {
                j = next[j - 1];
                
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
    
    /**
     * next 数组
     */
    private int[] next(String p) {
        var next = new int[p.length()];
        // j 指针记录前缀字符串和后缀字符串共同字符的数量
        for (int i = 1, j = 0; i < p.length(); i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) j = next[j - 1];
            if (p.charAt(i) == p.charAt(j)) j++;
            // p[1, j] = p[i - j + 1, i] 两段字符相等
            next[i] = j;
        }
        return next;
    }
    
}
