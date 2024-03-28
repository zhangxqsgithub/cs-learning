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
        
        // 99876 - 99321
        var res2 = solution.sub(Arrays.asList(6, 7, 8, 9, 9), Arrays.asList(1, 2, 3, 9, 9));
        System.out.println(res2);
        
        // 123 * 12 = 1476
        var res3 = solution.multiply(Arrays.asList(3, 2, 1), 12);
        System.out.println(res3);
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
    
    /**
     * 比较两个数的大小
     * num1 < num2 返回 -1
     * num1 == num2 返回 0
     * num1 > num2 返回 1
     */
    public int compare(List<Integer> num1, List<Integer> num2) {
        if (num1.size() != num2.size()) return num1.size() < num2.size() ? -1 : 1;
        int n = num1.size();
        for (int i = n - 1; i >= 0; i--) {
            if (num1.get(i).equals(num2.get(i))) continue;
            return num1.get(i) < num2.get(i) ? -1 : 1;
        }
        return 0;
    }
    
    public List<Integer> sub(List<Integer> num1, List<Integer> num2) {
        int n = num1.size();
        var res = new ArrayList<Integer>();
        int t = 0;
        for (int i = 0; i < n; i++) {
            t = num1.get(i) - t;
            if (i < num2.size()) t -= num2.get(i);
            res.add((t + 10) % 10);
            if (t < 0) t = 1;
            else t = 0;
        }
        // 将前导零去掉
        while (!res.isEmpty() && res.getLast() == 0) res.removeLast();
        return res;
    }
    
    public List<Integer> multiply(List<Integer> num1, int num2) {
        var res = new ArrayList<Integer>();
        int c = 0; // 进位
        for (int a : num1) {
            res.add((a * num2 + c) % 10);
            c = (a * num2 + c) / 10;
        }
        if (c != 0) res.add(c);
        return res;
    }
    
}
