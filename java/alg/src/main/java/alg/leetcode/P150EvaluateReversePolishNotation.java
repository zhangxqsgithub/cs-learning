package alg.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @link https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 * @author zhangxq
 * @since 2023/5/7
 */
public class P150EvaluateReversePolishNotation {
    
    public static void main(String[] args) {
        P150EvaluateReversePolishNotation solution = new P150EvaluateReversePolishNotation();
        
        solution.evalRPN(new String[]{"4", "13", "5", "/", "+"});
    }
    
    Stack<Integer> stk = new Stack<>();
    public int evalRPN(String[] tokens) {
        var set = Stream.of("+", "-", "*", "/").collect(Collectors.toSet());
        for (var token : tokens) {
            if (set.contains(token)) eval(token);
            else stk.push(Integer.valueOf(token));
        }
        return stk.pop();
    }
    
    public void eval(String s) {
        var b = stk.pop();
        var a = stk.pop();
        switch (s) {
            case "+" -> stk.push(a + b);
            case "-" -> stk.push(a - b);
            case "*" -> stk.push(a * b);
            case "/" -> stk.push(a / b);
        }
    }
    
}
