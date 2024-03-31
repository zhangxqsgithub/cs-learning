package alg.acwing;

import java.util.Scanner;

/**
 * 判断子序列
 * @link https://www.acwing.com/problem/content/2818/
 * @author will
 * @since 2024/3/28
 */
public class P2816 {
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        var arr1 = new int[m];
        var arr2 = new int[n];
        for (int i = 0; i < m; i++) arr1[i] = sc.nextInt();
        for (int i = 0; i < n; i++) arr2[i] = sc.nextInt();
        doublePointer(arr1, arr2);
    }
    
    /**
     * 这里用到贪心算法
     */
    public static void doublePointer(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (arr1[i] == arr2[j]) i++;
            j++;
        }
        // 若 i 指针走到最后的话
        if (i == m) System.out.println("Yes");
        else System.out.println("No");
    }
}
