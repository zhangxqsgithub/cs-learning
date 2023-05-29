package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/additive-number/
 * @author zhangxq
 * @since 2023/5/29
 */
public class P306AdditiveNumber {
    
    public static void main(String[] args) {
        P306AdditiveNumber solution = new P306AdditiveNumber();
        String res1 = solution.add("123", "789");
        System.out.println(res1);
    }
    
    public boolean isAdditiveNumber(String num) {
        for (int i = 0; i < num.length(); i++) {
            // 这里 j + 1 表示一个公式要有三个数，至少要给结果留一位数。
            for (int j = i + 1; j + 1 < num.length(); j++) {
                int a = -1, b = i, c = j;
                while (true) {
                    // 判断是否有前导 0，若有前导 0 则是不合法的
                    if (b - a > 1 && num.charAt(a + 1) == '0' || c - b > 1 && num.charAt(b + 1) == '0') break;
                    String x = num.substring(a + 1, b + 1), y = num.substring(b + 1, c + 1);
                    String z = add(x, y);
                    // 不匹配
                    if (!num.substring(c + 1, Math.min(num.length(), c + 1 + z.length())).equals(z)) break;
                    a = b; b = c; c += z.length();
                    if (c + 1 == num.length()) return true;
                }
            }
        }
        return false;
    }
    
    // 两个大数相加
    public String add(String x, String y) {
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        for (int i = x.length() - 1; i >= 0; i--) A.add(x.charAt(i) - '0');
        for (int i = y.length() - 1; i >= 0; i--) B.add(y.charAt(i) - '0');
        for (int i = 0, t = 0; i < A.size() || i < B.size() || t != 0; i++) {
            if (i < A.size()) t += A.get(i);
            if (i < B.size()) t += B.get(i);
            C.add(t % 10);
            t /= 10;
        }
        StringBuilder res = new StringBuilder();
        for (int i = C.size() - 1; i >= 0; i--) res.append(C.get(i));
        return res.toString();
    }
}
