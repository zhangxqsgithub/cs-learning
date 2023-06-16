package alg.leetcode;

import java.util.*;

/**
 * @link https://leetcode.cn/problems/concatenated-words/
 * @author zhangxq
 * @since 2023/6/16
 */
public class P472ConcatenatedWords {
    
    public static void main(String[] args) {
    
    }
    
    Set<String> set = new HashSet<>();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        set.addAll(Arrays.asList(words));
        var res = new ArrayList<String>();
        for (var w : words)
            if (check(w))
                res.add(w);
        return res;
    }
    private boolean check(String word) {
        var n = word.length();
        var dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            if (dp[i] < 0) continue;
            for (int j = n - i; j >= 0; j--) {
                if (set.contains(word.substring(i, i + j))) {
                    dp[i + j] = Math.max(dp[i + j], dp[i] + 1);
                    if (dp[n] > 1) return true;
                }
            }
        }
        return false;
    }
}
