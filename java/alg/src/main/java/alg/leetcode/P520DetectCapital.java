package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/detect-capital/
 * @author zhangxq
 * @since 2023/9/23
 */
public class P520DetectCapital {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 大写字母的个数只有三种情况 0、1、word.length
     */
    public boolean detectCapitalUse(String word) {
        int cnt = 0;
        for (int i = 0; i < word.length(); i++)
            if (Character.isUpperCase(word.charAt(i)))
                cnt++;
        return cnt == 0
                || (cnt == 1 && Character.isUpperCase(word.charAt(0)))
                || cnt == word.length();
    }
}
