package alg.acwing;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * 表达式求值
 * @link https://www.acwing.com/problem/content/submission/3305/
 * @author will
 * @since 2024/4/9
 */
public class P3302 {
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var exp = sc.next();
        var solution = new P3302();
        var res = solution.evaluation(exp);
        System.out.println(res);
    }
    
    private Stack<Integer> num = new Stack<>();
    private Stack<Character> op = new Stack<>();
    public int evaluation(String exp) {
        var pri = Map.of('+', 1, '-', 1, '*', 2, '/', 2);
        for (int i = 0; i < exp.length(); i++) {
            var c = exp.charAt(i);
            if (Character.isDigit(c)) {
                int x = 0, j = i;
                while (j < exp.length() && Character.isDigit(exp.charAt(j))) {
                    x = x * 10 + (exp.charAt(j++) - '0');
                }
                num.push(x);
                i = j - 1;
            }
            else if (c == '(') {
                op.push(c);
            }
            else if (c == ')') {
                while (!op.isEmpty() && op.peek() != '(') eval();
                op.pop();
            }
            else {
                while (!op.isEmpty() && pri.getOrDefault(op.peek(), 0) >= pri.get(c)) eval();
                op.push(c);
            }
        }
        while (!op.isEmpty()) eval();
        return num.peek();
    }
    
    private void eval() {
        int b = num.pop(), a = num.pop(), x = 0;
        char c = op.pop();
        if (c == '+') x = a + b;
        else if (c == '-') x = a - b;
        else if (c == '*') x = a * b;
        else if (c == '/') x = a / b;
        num.push(x);
    }
    
}
