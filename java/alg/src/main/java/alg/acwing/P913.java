package alg.acwing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 排队打水
 * @link https://www.acwing.com/problem/content/description/915/
 * @author will
 * @since 2024/5/21
 */
public class P913 {
    
    /**
     * 按照从小到大排队，总时间最小。
     * a * b + x * y     a,b,x,y > 0; a < x; b > y
     * a * y + b * x
     * 1 * 2 + 2 * 1 = 4
     * 1 * 1 + 2 * 2 = 5
     */
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        long res = 0L;
        for (int i = 0; i < n; i++) {
            res += (long) arr[i] * (n - i - 1);
        }
        System.out.println(res);
    }
}
