package alg.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/maximum-product-of-word-lengths/
 * @author zhangxq
 * @since 2023/5/30
 */
public class P318MaximumProductOfWordLengths {
    
    public static void main(String[] args) {
        P318MaximumProductOfWordLengths solution = new P318MaximumProductOfWordLengths();
        solution.maxProduct(new String[]{"d"});
    }
    
    public int maxProduct(String[] words) {
        int n = words.length;
        // 用于判断两个单词是否有相同字母
        int[] bit = new int[n];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int x = 0;
            for (int j = 0; j < word.length(); j++) x |= 1 << (word.charAt(j) - 'a');
            bit[i] = x;
        }
        
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bit[i] & bit[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        
        return res;
    }
}
