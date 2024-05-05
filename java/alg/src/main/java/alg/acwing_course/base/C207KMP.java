package alg.acwing_course.base;

import java.util.ArrayList;
import java.util.Arrays;
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
        // 求 next 数组
        var next = next(p);
        // i 记录字符串 s 的下标， j 记录字符串 p 的下标
        for (int i = 0, j = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) j = next[j - 1];
            if (s.charAt(i) == p.charAt(j)) j++;
            // 匹配成功
            if (j == p.length()) {
                j = next[j - 1];
                // 记录已经匹配的结果下标
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
    
    /**
     * next 数组
     * 例如字符串 ababc
     * next[i] 保存的是字符串 p[0, i] 的所有前缀和后缀中字符最大重复数。
     * next[0] = 0，因为如果字符串只有一个字符的话是没有前缀和后缀的。
     * next[1] = 0
     * next[2] = 1
     * next[3] = 2
     * next[4] = 0
     */
    private int[] next(String p) {
        var next = new int[p.length()];
        // j 指针记录前缀字符串和后缀字符串共同字符的数量
        for (int i = 1, j = 0; i < p.length(); i++) {
            // 这里相当于递归调用 next 方法，也算是 dp 的一种，就是使用 next 数组之前计算好的值。
            // 如果 j 没有退回起点，也就是说前面已经有一些字符串匹配成功了。
            // 并且 j 这个位置的字符不匹配，那么就要通过 next 数组向前退步，直到遇到 j 退到 0
            // 或者退到某个位置使得 p[i] = p[j]， 那么就确定了 j 的位置，继续向下匹配
            while (j > 0 && p.charAt(i) != p.charAt(j)) j = next[j - 1];
            if (p.charAt(i) == p.charAt(j)) j++;
            // p[1, j] = p[i - j + 1, i] 两段字符相等
            next[i] = j;
        }
        return next;
    }

    private int[] next2(String p) {
        int n = p.length();
        var next = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            // j > 0 表示 j 之前有匹配了的字符
            // 并且当前匹配的字符是不相等的，就要递归使用 next 数组
            while (j > 0 && p.charAt(i) != p.charAt(j)) j = next[j - 1];
            if (p.charAt(i) == p.charAt(j)) j++;
            next[i] = j;
        }
        return next;
    }
    
}
