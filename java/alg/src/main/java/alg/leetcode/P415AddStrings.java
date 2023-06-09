package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/add-strings/
 * @author zhangxq
 * @since 2023/6/9
 */
public class P415AddStrings {
    
    public static void main(String[] args) {
        var solution = new P415AddStrings();
        var res = solution.addStrings("11", "789");
        System.out.println(res);
    }
    
    public String addStrings(String num1, String num2) {
        var sb = new StringBuilder();
        int m = num1.length(), n = num2.length();
        int carry = 0;
        for (int i = m - 1, j = n - 1; i >= 0 || j >= 0; i--, j--) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            int c = a + b + carry;
            sb.append(c % 10);
            carry = c / 10;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
