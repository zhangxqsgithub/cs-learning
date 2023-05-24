package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/different-ways-to-add-parentheses/
 * @author zhangxq
 * @since 2023/5/24
 */
public class P241DifferentWaysToAddParentheses {
    
    public static void main(String[] args) {
    
    }
    
    List<String> expr = new ArrayList<>();
    public List<Integer> diffWaysToCompute(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                int j = i, x = 0;
                while (j < expression.length() && Character.isDigit(expression.charAt(j))) {
                    x = x * 10 + (expression.charAt(j++) - '0');
                }
                i = j - 1;
                expr.add(String.valueOf(x));
            }
            else expr.add(String.valueOf(c));
        }
        return dfs(0, expr.size() - 1);
    }
    
    public List<Integer> dfs(int l, int r) {
        if (l == r) {
            List<Integer> res = new ArrayList<>();
            res.add(Integer.parseInt(expr.get(l)));
            return res;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = l + 1; i < r; i += 2) {
            String e = expr.get(i);
            var left = dfs(l, i - 1);
            var right = dfs(i + 1, r);
            for (var x : left)
                for (var y : right) {
                    int z = 0;
                    switch (e) {
                        case "+" -> z = x + y;
                        case "-" -> z = x - y;
                        case "*" -> z = x * y;
                    }
                    res.add(z);
                }
        }
        return res;
    }
    
}
