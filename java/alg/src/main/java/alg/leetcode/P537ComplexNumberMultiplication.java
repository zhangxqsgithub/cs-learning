package alg.leetcode;

import java.util.Scanner;

/**
 * @link https://leetcode.cn/problems/complex-number-multiplication/
 * @author zhangxq
 * @since 2023/9/26
 */
public class P537ComplexNumberMultiplication {
    
    public static void main(String[] args) {
        var solution = new P537ComplexNumberMultiplication();
        solution.complexNumberMultiply("11+22i", "2+2i");
    }
    
    public String complexNumberMultiply(String num1, String num2) {
        var sc1 = new Scanner(num1).useDelimiter("[\\+|i]");
        var a = sc1.nextInt();
        var b = sc1.nextInt();
        var sc2 = new Scanner(num2).useDelimiter("[\\+|i]");
        var c = sc2.nextInt();
        var d = sc2.nextInt();
        return (a * c - b * d) + "+" + (a * d + b * c) + "i";
    }
}
