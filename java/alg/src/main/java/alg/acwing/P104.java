package alg.acwing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 货仓选址
 *
 * 扩展到二维 3167 题 https://www.acwing.com/problem/content/description/3170/
 * 扩展到 D 维：需要用模拟退火算法。
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
        int res = 0;
        for (int i = 0; i < n; i++) res += Math.abs(arr[i] - w);
        System.out.println(res);
    }
}
