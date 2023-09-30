package alg.leetcode;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/fraction-addition-and-subtraction/
 * @since 2023/9/30
 */
public class P592FractionAdditionAndSubtraction {
    
    public static void main(String[] args) {
    
    }
    
    public String fractionAddition(String expression) {
        int a = 0, b = 1, offset = 0;
        if (expression.charAt(0) != '-') expression = "+" + expression;
        for (int i = 1; i < expression.length(); i++) {
            int start = i;
            while (i < expression.length() && expression.charAt(i) != '+' && expression.charAt(i) != '-') i++;
            int slash = expression.indexOf('/', start);
            int c = Integer.parseInt(expression.substring(start, slash));
            int d = Integer.parseInt(expression.substring(slash + 1, i));
            // 处理负号
            if (start > 0 && expression.charAt(start - 1) == '-') c = -c;
            int x = a * d + b * c, y = b * d;
            int z = gcd(x, y);
            a = x / z; b = y / z;
        }
        if (b < 0) { a = -a; b = -b; }
        return a + "/" + b;
    }
    
    // 求最大公约数
    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
