package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/base-7
 * @author zhangxq
 * @since 2023/9/17
 */
public class P504Base7 {
    
    public static void main(String[] args) {
    
    }
    
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        // 是否为负数
        var isNegative = num < 0;
        num = Math.abs(num);
        var sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        sb.reverse();
        if (isNegative) return "-" + sb;
        else return sb.toString();
    }
}
