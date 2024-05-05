package alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 参考 https://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
 * KMP 算法是字符串搜索算法，即给定一个很长的文本 text 和需要搜索的关键字 pattern，在 text 中搜索 pattern
 * 出现的位置，并返回所有出现位置的开始下标，即返回一个 int 数组。
 *
 *
 */
public class KMP {
    
    public static void main(String[] args) {
        var kmp = new KMP();
        var res1 = kmp.prefixTable("ABABCABAA");
        System.out.println(Arrays.toString(res1));
        kmp.movePrefixTable(res1);
        System.out.println(Arrays.toString(res1));
    
        var indexes = kmp.kmpSearch("ABCABABCA", "ABC");
        System.out.println(indexes);
    }
    
    // 暴力搜索字符串
    public int strSearch(String text, String pattern) {
        int n = text.length(), m = pattern.length();
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            // 找到
            if (flag) return i;
        }
        return -1;
    }
    
    public List<Integer> kmpSearch(String text, String pattern) {
        List<Integer> res = new ArrayList<>();
        int[] prefixTable = prefixTable(pattern);
        movePrefixTable(prefixTable);
        
        int m = text.length(), n = pattern.length();
        int i = 0, j = 0;
        while (i < m) {
            // 匹配到了
            if (j == n - 1 && text.charAt(i) == pattern.charAt(j)) {
                res.add(i - j);
                j = prefixTable[j];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                ++i;
                ++j;
            }
            else {
                j = prefixTable[j];
                if (j == -1) {
                    ++i;
                    ++j;
                }
            }
        }
        return res;
    }
    
    // 整个前缀数组往后移动一位
    private void movePrefixTable(int[] prefixTable) {
        int n = prefixTable.length;
        // System.arraycopy(prefixTable, 0, prefixTable, 1, n - 1);
        for (int i = n - 1; i > 0; i--) {
            prefixTable[i] = prefixTable[i - 1];
        }
        prefixTable[0] = -1;
    }
    
    // 前缀数组
    private int[] prefixTable(String pattern) {
        int n = pattern.length();
        int[] prefixTable = new int[n];
        if (pattern.length() == 0) return prefixTable;
        
        int len = 0;
        int i = 1;
        while (i < n) {
            if (pattern.charAt(len) == pattern.charAt(i)) {
                ++len;
                prefixTable[i] = len;
                ++i;
            }
            else {
                if (len > 0) {
                    len = prefixTable[len - 1];
                }
                else {
                    prefixTable[i] = len;
                    ++i;
                }
            }
        }
        return prefixTable;
    }
    
}
