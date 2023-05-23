package alg.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/basic-calculator-ii/
 * @since 2023/5/23
 */
public class P227BasicCalculatorII {
    
    public static void main(String[] args) {
    
    }
    
    Map<Character, Integer> priority = new HashMap<>() {{
        put('+', 1);
        put('-', 1);
        put('*', 2);
        put('/', 2);
    }};
    
    public int calculate(String s) {
        s = s.replace(" ", "");
        var nums = new Stack<Integer>();
        var ops = new Stack<Character>();
        for (var i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') ops.push(c);
            else if (c == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') eval(nums, ops);
                ops.pop();
            }
            else if (Character.isDigit(c)) {
                int x = 0, j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    x = x * 10 + (s.charAt(j++) - '0');
                }
                nums.push(x);
                i = j - 1;
            }
            else { // operator
                // 解决数字带有正负号的问题
                if (i == 0 || s.charAt(i - 1) == '(') nums.push(0);
                while (!ops.isEmpty() && ops.peek() != '(' && priority.get(ops.peek()) >= priority.get(c)) {
                    eval(nums, ops);
                }
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) eval(nums, ops);
        return nums.pop();
    }
    
    public void eval(Stack<Integer> nums, Stack<Character> ops) {
        var b = nums.pop();
        var a = nums.pop();
        var o = ops.pop();
        var res = 0;
        switch (o) {
            case '+' -> res = a + b;
            case '-' -> res = a - b;
            case '*' -> res = a * b;
            case '/' -> res = a / b;
        }
        nums.push(res);
    }
    
}
