package alg.leetcode;

import java.util.Stack;

/**
 * @link https://leetcode.cn/problems/basic-calculator/
 * @author zhangxq
 * @since 2023/5/22
 */
public class P224BasicCalculator {
    
    public static void main(String[] args) {
        P224BasicCalculator solution = new P224BasicCalculator();
        int val1 = solution.calculate("1-(     -2)");
        System.out.println(val1);
    }
    
    public int calculate(String s) {
        // 去除掉所有空格
        s = s.replace(" ", "");
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') ops.push(c);
            else if (c == ')') {
                // 一直处理到左括号为止
                while (ops.peek() != '(') eval(nums, ops);
                ops.pop(); // 将 ( 弹出栈
            }
            // 数字加到栈里面
            else if (Character.isDigit(c)) {
                int x = 0, j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    x = x * 10 + (s.charAt(j++) - '0');
                }
                i = j - 1;
                nums.push(x);
            }
            else {
                // 特殊处理正负号数的问题
                if (i == 0 || s.charAt(i - 1) == '(') nums.push(0);
                while (!ops.isEmpty() && ops.peek() != '(') eval(nums, ops);
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) eval(nums, ops);
        return nums.peek();
    }
    
    public void eval(Stack<Integer> nums, Stack<Character> ops) {
        var b = nums.pop();
        var a = nums.pop();
        var c = ops.pop();
        int r = 0;
        if (c == '+') r = a + b;
        else if (c == '-') r = a - b;
        nums.push(r);
    }
}
