package alg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 串联所有单词的子串
 *
 * @author zhangxq
 * @link https://leetcode.cn/problems/substring-with-concatenation-of-all-words/
 * @since 2022/12/27
 */
public class P30SubstringWithConcatenationOfAllWords {
    
    public static void main(String[] args) {
    
    }
    
    public List<Integer> findSubstring(String s, String[] words) {
        var res = new ArrayList<Integer>();
        if (words.length == 0) return res;
        int n = s.length(), m = words.length, w = words[0].length();
        
        // 记录 words 中每个单词出现的次数
        var tot = new HashMap<String, Integer>();
        for (var word: words) tot.put(word, tot.getOrDefault(word, 0) + 1);
        
        for (var i = 0; i < w; i++) {
            var wd = new HashMap<String, Integer>();
            // 统计窗口内单词在 words 中出现的次数
            var cnt = 0;
            for (var j = i; j + w <= n; j += w) {
                
                // 窗口已经满，需要去掉窗口最左边的单词，才能在窗口中添加新的单词
                if (j >= i + m * w) {
                    // 获取窗口最左边的单词
                    var word = s.substring(j - m * w, w + j - m * w);
                    wd.put(word, wd.getOrDefault(word, 0) - 1);
                    if (tot.containsKey(word) && wd.get(word) < tot.get(word)) cnt--;
                }
                var word = s.substring(j, j + w);
                wd.put(word, wd.getOrDefault(word, 0) + 1);
                if (tot.containsKey(word) && wd.get(word) <= tot.get(word)) cnt++;
                if (cnt == m) res.add(j - (m - 1) * w);
            }
        }
        return res;
    }
    
}
