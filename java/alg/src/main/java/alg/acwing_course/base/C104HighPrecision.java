package alg.acwing_course.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 高精度加减乘除
 * @author will
 * @since 2024/3/26
 */
public class C104HighPrecision {
    
    public static void main(String[] args) {
        var solution = new C104HighPrecision();
        // 321 + 987
        var res1 = solution.add2(Arrays.asList(1, 2, 3), Arrays.asList(7, 8, 9));
        System.out.println(res1);
    }
    
    public List<Integer> add(List<Integer> num1, List<Integer> num2) {
        int n = Math.max(num1.size(), num2.size());
        var res = new ArrayList<Integer>(n);
        int c = 0;
        for (int i = 0; i < n; i++) {
            int a = 0, b = 0;
            if (i < num1.size()) a = num1.get(i);
            if (i < num2.size()) b = num2.get(i);
            int sum = a + b + c;
            if (sum >= 10) {
                c = sum / 10;
                sum %= 10;
            }
            res.add(sum);
        }
        if (c != 0) res.add(c);
        return res;
    }
    
    /**
     * y 总的简洁版
     */
    public List<Integer> add2(List<Integer> num1, List<Integer> num2) {
        int n = Math.max(num1.size(), num2.size());
        var res = new ArrayList<Integer>(n);
        int t = 0;
        for (int i = 0; i < n; i++) {
            if (i < num1.size()) t += num1.get(i);
            if (i < num2.size()) t += num2.get(i);
            res.add(t % 10);
            t /= 10;
        }
        if (t != 0) res.add(t);
        return res;
    }
}
