package alg.acwing_course.base;

import java.util.Map;
import java.util.Stack;

/**
 * @author will
 * @since 2024/4/8
 */
public class C203Expression {

    /**
     * 子树遍历完成的条件：当前运算符的优先级 >= 上一个运算符的优先级
     */
    public static void main(String[] args) {
        var solution = new C203Expression();
        var res1 = solution.evaluation("1+1*2");
        System.out.println(res1);
    }
    
    // 存储数字的栈
    private Stack<Integer> num;
    // 存储运算符的栈
    private Stack<Character> op;
    // 求值
    public int evaluation(String exp) {
        num = new Stack<>(); op = new Stack<>();
        // 定义运算符优先级
        var pri = Map.of('+', 1, '-', 1, '*', 2, '/', 2);
        for (int i = 0; i < exp.length(); i++) {
            if (Character.isDigit(exp.charAt(i))) { // 若为数字
                int x = 0, j = i;
                while (j < exp.length() && Character.isDigit(exp.charAt(j))) {
                    x = x * 10 + (exp.charAt(j++) - '0');
                }
                num.push(x);
                i = j - 1;
            }
            else if (exp.charAt(i) == '(') { // 左括号
                op.push(exp.charAt(i));
            }
            else if (exp.charAt(i) == ')') { // 右括号
                while (!op.isEmpty() && op.peek() != '(') eval();
                op.pop();
            }
            else { // 一般运算符
                // 注意这里的 pri.get(op.peek()) 可能会空指针
                // 因为之前 push 入 op 栈的可能是 (s
                while (!op.isEmpty() && pri.getOrDefault(op.peek(), 0) >= pri.get(exp.charAt(i))) eval();
                op.push(exp.charAt(i));
            }
        }
        while (!op.isEmpty()) eval();
        return num.peek();
    }
    
    // 操作最后一个运算符
    private void eval() {
        int b = num.pop(), a = num.pop();
        var c = op.pop();
        var x = switch (c) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> throw new IllegalStateException("Unexpected value: " + c);
        };
        num.push(x);
    }
}
