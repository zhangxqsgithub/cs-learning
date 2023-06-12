package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/string-compression/
 * @author zhangxq
 * @since 2023/6/12
 */
public class P443StringCompression {
    
    public static void main(String[] args) {
    
    }
    
    public int compress(char[] chars) {
        var sb = new StringBuilder();
        for (int i = 0, j = 0; i < chars.length; i++, j++) {
            char cur = chars[i];
            chars[j] = cur;
            sb.append(cur);
            int k = i;
            while (k < chars.length && chars[k] == cur) k++;
            if (k - 1 != i) {
                var t = String.valueOf(k - i);
                for (int a = 0; a < t.length(); a++) chars[++j] = t.charAt(a);
                sb.append(t);
                i = k - 1;
            }
        }
        return sb.length();
    }
}
