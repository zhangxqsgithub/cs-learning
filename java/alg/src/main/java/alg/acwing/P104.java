package alg.acwing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 货仓选址
 *
 * @link https://www.acwing.com/problem/content/description/106/
 * @author will
 * @since 2024/5/21
 */
public class P104 {
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        // 选择中间位置的点作为货仓
        int w = arr[n / 2];
        long res = 0L;
        for (int i = 0; i < n; i++) res += Math.abs(arr[i] - w);
        System.out.println(res);
    }
}
