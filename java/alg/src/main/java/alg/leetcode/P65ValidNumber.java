package alg.leetcode;

/**
 * 有效数字
 *
 * @author zhangxq
 * @link https://leetcode.cn/problems/valid-number/
 * @since 2023/1/14
 */
public class P65ValidNumber {
    
    public static void main(String[] args) {
    
    }
    
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) return false;
        // 开头结尾是 +- 号的
        if (s.charAt(0) == '+' || s.charAt(0) == '-') s = s.substring(1);
        if (s.isEmpty()) return false;
        if (s.charAt(0) == '.' && (s.length() == 1 || s.charAt(1) == 'e' || s.charAt(1) == 'E')) return false;
        // 记录 . 和 e 出现的次数
        int dot = 0, e = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '.') {
                if (dot > 0 || e > 0) return false;
                dot++;
            }
            else if (c == 'e' || c == 'E') {
                if (i == 0 || i + 1 == s.length() || e > 0) return false;
                if (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-') {
                    if (i + 2 == s.length()) return false;
                    i++; // 跳过正负号
                }
                e++;
            }
            // 字符不是阿拉伯数字
            else if (s.charAt(i) < '0' || s.charAt(i) > '9') return false;
        }
        return true;
    }
    
}
