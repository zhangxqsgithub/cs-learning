package alg.leetcode;

import java.util.HashSet;
import java.util.List;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/word-break/
 * @since 2023/5/3
 */
public class P139WordBreak {
    
    public static void main(String[] args) {
    
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        // acw 类同前面的分隔回文串很像，n个字母，n-1个空，都可以选择切分或不切。指数级别的，可以用dp优化
        // dp[i] 表示长度为i的串能否拆分为单词列表中的单词。 考虑最后一个单词，其可以是1-i, 2-i, .k-i.. i-i 这些长度。
        // k的范围 1-i  。所以dp[i] = dp[k - 1] && s[k, i]在单词中出现过。
        // 最后，如何快速判断一个字符串在字典中出现过，有两种方式，一种是trie树，接近o1, 第二种是手写hash。方法是：
        // 通过将字符串转换为数字，然后判断数字是否在hash表中存在。o1。
        // 具体：将字符串看成一个P进制数，P802 一般为131, 或13331。 Q取余一般为2的64次方。
        // （因为字符串 hash 不需要处理 hash 冲突！所以时间复杂度小）
        var P = 131;
        var hash = new HashSet<>();
        for (String str : wordDict) {
            var num = 0L;
            // 将每个单词转换为数字
            for (var ch : str.toCharArray()) num = num * P + ch;
            hash.add(num);
        }
        
        var n = s.length();
        var dp = new boolean[n + 1];
        dp[0] = true;
        s = " " + s;
        for (var i = 0; i < n; i++) {
            if (dp[i]) {
                // 这里从前向后递推
                var num = 0L;
                for (var j = i + 1; j <= n; j++) {
                    num = num * P + s.charAt(j);
                    if (hash.contains(num)) dp[j] = true;
                }
            }
        }
        
        return dp[n];
    }
}
