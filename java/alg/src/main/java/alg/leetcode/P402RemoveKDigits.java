package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/remove-k-digits/
 * @author zhangxq
 * @since 2023/6/8
 */
public class P402RemoveKDigits {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 贪心
     */
    public String removeKdigits(String num, int k) {
        k = Math.min(k, num.length());
        var res = new StringBuilder();
        for (var c : num.toCharArray()) {
            while (k != 0 && !res.isEmpty() && res.charAt(res.length() - 1) > c) {
                k--;
                res.deleteCharAt(res.length() - 1);
            }
            res.append(c);
        }
        // 没有删除干净的情况
        while (k-- > 0) res.deleteCharAt(res.length() - 1);
        k = 0;
        while (k < res.length() && res.charAt(k) == '0') k++;
        if (k == res.length()) res.append(0);
        return res.substring(k);
    }
}
