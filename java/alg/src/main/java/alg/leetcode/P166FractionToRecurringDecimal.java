package alg.leetcode;

import java.util.HashMap;

/**
 * @link https://leetcode.cn/problems/fraction-to-recurring-decimal/
 * @author zhangxq
 * @since 2023/5/7
 */
public class P166FractionToRecurringDecimal {
    
    public static void main(String[] args) {
    }
    
    public String fractionToDecimal(int numerator, int denominator) {
        long x = numerator, y = denominator;
        if (x % y == 0) return String.valueOf(x / y);
        var res = new StringBuilder();
        // 判断结果是否为负数
        if ((x < 0) ^ (y < 0)) res.append('-');
        x = Math.abs(x); y = Math.abs(y);
        // 首先算整数的部分
        res.append(x / y).append('.'); x %= y;
        
        // 记录出现过的余数
        var hash = new HashMap<Long, Integer>();
        while (x != 0) {
            hash.put(x, res.length());
            x *= 10;
            res.append(x / y);
            x %= y;
            if (hash.containsKey(x)) {
                // 解决循环节的括号问题
                res.insert((int) hash.get(x), '(');
                res.append(')');
                break;
            }
        }
        return res.toString();
    }
}
