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
    
    // 这个解法是错误的
    public boolean isNumber(String s) {
        // 去掉前后空格
        s = s.trim();
        char[] a = s.toCharArray();
        int n = s.length();
        if (n == 0) return false;
        // 去掉前面正负号
        if (a[0] == '+' || a[0] == '-') s = s.substring(1);
        a = s.toCharArray();
        n = a.length;
        if (n == 0) return false;
        if (a[0] == '.' && (n == 1 || a[1] == 'e' || a[1] == 'E')) return false;
        // 记录 . 和 e 出现的次数
        int dot = 0, e = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == '.') {
                if (dot > 0 || e > 0) return false;
                dot++;
            }
            else if (a[i] == 'e' || a[i] == 'E') {
                if (i != 0 || i + 1 == n || e > 0) return false;
                if (a[i + 1] == '+' || a[i + 1] == '-') {
                    if (i + 2 == n) return false;
                    // 把正负号跳过
                    i++;
                }
                e++;
            }
            else if (a[i] < '0' || a[i] > '9') {
                return false;
            }
        }
        return true;
    }
    
}
