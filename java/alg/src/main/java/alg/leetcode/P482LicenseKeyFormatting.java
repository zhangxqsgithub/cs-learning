package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/license-key-formatting/
 * @author zhangxq
 * @since 2023/9/11
 */
public class P482LicenseKeyFormatting {
    
    public static void main(String[] args) {
    }
    
    public String licenseKeyFormatting(String s, int k) {
        var res = new StringBuilder();
        var cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            var c = Character.toUpperCase(s.charAt(i));
            if (c == '-') continue;
            if (cnt == k) {
                res.append('-');
                cnt = 0;
            }
            res.append(c);
            cnt++;
        }
        return res.reverse().toString();
    }
}
