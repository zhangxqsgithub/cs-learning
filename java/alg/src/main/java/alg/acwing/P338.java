package alg.acwing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 计数问题
 * @link https://www.acwing.com/problem/content/340/
 * @author will
 * @since 2024/5/15
 */
public class P338 {
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        while (true) {
            int a = sc.nextInt(), b = sc.nextInt();
            if (a == 0 && b == 0) break;
            // a 为小的数
            if (a > b) { var t = a; a = b; b = t; }
            // 枚举 0 ～ 9 出现的次数
            for (int i = 0; i < 10; i++) {
                System.out.print((count(b, i) - count(a - 1, i)) + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * 统计从 1 ～ n 中数字 x 出现的次数
     */
    private static int count(int n, int x) {
        if (n <= 0) return 0;
        var num = new ArrayList<Integer>();
        while (n != 0) {
            num.add(n % 10);
            n /= 10;
        }
        n = num.size(); // n 表示为数字的位数
        var res = 0;
        // 对于0，不需要枚举最高位
        for (int i = n - 1 - (x == 0 ? 1 : 0); i >= 0; i--) {
            if (i < n - 1) {
                res += getNum(num, n - 1, i + 1) * (int) Math.pow(10, i);
                if (x == 0) res -= (int) Math.pow(10, i);
            }
            if (num.get(i) == x) res += getNum(num, i - 1, 0) + 1;
            else if (num.get(i) > x) res += (int) Math.pow(10, i);
        }
        return res;
    }
    
    /**
     * 求数字 num 中下标 [r, l] 中保存的数字
     * 因为数字是小端存储的
     */
    private static int getNum(List<Integer> num, int l, int r) {
        var res = 0;
        for (int i = l; i >= r; i--) {
            res = res * 10 + num.get(i);
        }
        return res;
    }
}
