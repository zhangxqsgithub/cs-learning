package alg.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/word-break-ii/
 * @since 2023/5/3
 */
public class P140WordBreakII {
    
    List<String> res = new ArrayList<>();
    Set<String> wordHash = new HashSet<>();
    StringBuilder ways = new StringBuilder();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        wordHash = new HashSet<>(wordDict);
        var n = s.length();
        
        // f[i]表示把s的前i个位置划分为若干单词，这些划分的单词是否都在wordHash中
        var f = new boolean[n + 1];
        // 初始化： f[0]表示没有单词为空，当然wordHash中也包含空
        f[0] = true;
        
        // 下标从1开始，可以舍去边界的判断
        for (var i = 1; i <= n; i++) {
            // 按照划分后最后一个单词的起点进行集合的划分
            for (var j = 1; j <= i; j++) { // j表示划分后最后一个单词的起点
                f[i] = f[j - 1] && wordHash.contains(s.substring(j - 1, i));
                if (f[i]) { // 这一步必须要，只有有一种划分方案满足即可
                    break;
                }
            }
        }
        
        if (!f[n]) return res;
        dfs(s, 0);
        return res;
    }
    
    public void dfs(String s, int start) {
        if (start == s.length()) {
            res.add(ways.substring(0, ways.length() - 1));
            return;
        }
        
        for (var n = 1; n + start <= s.length(); n++) {
            String sub = s.substring(start, start + n);
            if (wordHash.contains(sub)) {
                ways.append(sub).append(" ");
                dfs(s, start + n);
                ways.delete(ways.length() - sub.length() - 1, ways.length());
            }
        }
    }
    
}
