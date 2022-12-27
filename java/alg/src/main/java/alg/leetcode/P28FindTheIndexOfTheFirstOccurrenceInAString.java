package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
 * @author zhangxq
 * @since 2022/12/26
 */
public class P28FindTheIndexOfTheFirstOccurrenceInAString {
    
    public static void main(String[] args) {
        var s1 = "ababa";
        var p1 = "ababa";
        var solution = new P28FindTheIndexOfTheFirstOccurrenceInAString();
        var res1 = solution.strStr(s1, p1);
        System.out.println(res1);
    }
    
    public int strStr(String s, String p) {
        if (s.isEmpty()) return 0;
        int n = s.length(), m = p.length();
        // 让字符串下标从 1 开始
        s = " " + s;
        p = " " + p;
        
        // next[i] 为所有 p[1 ~ i] 的相等的前缀和后缀中，长度的最大值。
        // （注意这里是非平凡的前后缀，即不是源串即作为前缀又作为后缀，例 abc 的前缀没有 abc，后缀也没有 abc）
        // 若 p[1 ~ 5] 为 ababa
        // 前缀为         aba
        // 后缀为           aba
        // 前后缀相等，都为 aba，则计算 next[5] = 3
        // 计算 next 数组
        var next = new int[m + 1];
        for (int i = 2, j = 0; i <= m; i++) {
            // 判断源串第 i 个字母和 下一个字母 j + 1 是否相等
            while (j != 0 && p.charAt(i) != p.charAt(j + 1)) j = next[j];
            if (p.charAt(i) == p.charAt(j + 1)) j++;
            next[i] = j;
        }
        
        // 开始找字符串
        for (int i = 1, j = 0; i <= n; i++) {
            // 找到第一个不想等的字符
            while (j != 0 && s.charAt(i) != p.charAt(j + 1)) j = next[j];
            if (s.charAt(i) == p.charAt(j + 1)) j++;
            // 如果比较的字符串长度是 搜索的字符串长度，则说明匹配成功
            if (j == m) return i - m;
        }
        return -1;
    }
}
