package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/decode-string/
 * @author zhangxq
 * @since 2023/6/6
 */
public class P394DecodeString {
    
    public static void main(String[] args) {
        var solution = new P394DecodeString();
        String res = solution.decodeString("3[a]2[bc]");
        System.out.println(res);
    }
    
    int u;
    public String decodeString(String s) {
        u = 0;
        return dfs(s);
    }
    public String dfs(String s) {
        var res = new StringBuilder();
        if (u == s.length()) return res.toString();
        while (u < s.length() && s.charAt(u) != ']') { // 到右括号结束
            char c = s.charAt(u);
            if (Character.isDigit(c)) {
                int x = 0, k = u;
                while (k < s.length() && Character.isDigit(s.charAt(k))) {
                    x = x * 10 + (s.charAt(k) - '0');
                    k++;
                }
                u = k + 1; // 过掉左括号
                String str = dfs(s);
                u++; // 过掉右括号
                res.append(str.repeat(x));
            }
            else if (Character.isLetter(c)) {
                res.append(c);
                u++;
            }
        }
        return res.toString();
    }
}
