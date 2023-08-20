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
        //定义next数组，长度为p的长度
        int[] next = new int[p.length()];
        //从第二个字符开始遍历p
        for (int i = 1, j = 0; i < p.length(); i++) {
            //当j为0时，表示遍历到了第一个字符
            while (j > 0 && p.charAt(i)!= p.charAt(j)) j = next[j - 1];
            //如果遍历到的字符和当前字符相同，则j++
            if (p.charAt(i) == p.charAt(j)) j++;
            //将j赋值给next数组
            next[i] = j;
        }
        //返回next数组
        return next;
    }
    
    public int[] next(char[] p) {
        // 获取字符串p的长度
        var n = p.length;
        // 创建一个长度为n的数组next
        var next = new int[n];
        // 循环遍历字符串p
        for (int i = 1, cnt = 0; i < n; i++) {
            // 如果cnt不为0，则表示当前字符不等于前一个字符，则将cnt置为next[cnt-1]
            while (cnt!= 0 && p[i]!= p[cnt]) cnt = next[cnt - 1];
            // 如果当前字符等于前一个字符，则将cnt加1
            if (p[i] == p[cnt]) cnt++;
            // 将cnt赋值给next[i]
            next[i] = cnt;
        }
        // 返回next数组
        return next;
    }
    
    public List<Integer> kmp(String s, String p) {
        // 创建一个存放KMP算法结果的数组
        var positions = new ArrayList<Integer>();
        // 获取模式串的next数组
        int[] next = next(p);
        // 遍历字符串s
        for (int i = 0, j = 0; i < s.length(); i++) {
            // 当j不等于0时，表示当前字符不等于模式串的第一个字符，因此j减一
            while (j > 0 && s.charAt(i)!= p.charAt(j)) j = next[j - 1];
            // 当当前字符等于模式串的第一个字符时，j加一
            if (s.charAt(i) == p.charAt(j)) j++;
            // 当j等于模式串的长度时，表示当前字符等于模式串
            if (j == p.length()) {
                // j减去模式串长度，表示当前字符在模式串中的位置
                j = next[j - 1];
                // 将当前字符在模式串中的位置添加到positions数组中
                positions.add(i - p.length() + 1);
            }
        }
        // 返回positions数组
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
