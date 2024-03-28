package alg.acwing;

import java.util.Scanner;

/**
 * @author will
 * @link https://www.acwing.com/problem/content/802/
 * @since 2024/3/28
 */
public class P800 {
    
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        var m = scanner.nextInt();
        var x = scanner.nextInt();
        var arr1 = new int[n];
        for (int i = 0; i < n; i++) arr1[i] = scanner.nextInt();
        var arr2 = new int[m];
        for (int i = 0; i < m; i++) arr2[i] = scanner.nextInt();
        doublePointer(arr1, arr2, x);
    }
    
    /**
     * 暴力做法
     */
    public static void force(int[] arr1, int[] arr2, int x) {
        for (int i = 0; i < arr1.length; i++)
            for (int j = 0; j < arr2.length; j++)
                if (x == arr1[i] + arr2[j]) {
                    System.out.println(i + " " + j);
                    return;
                }
    }
    
    /**
     * 升续排序数组
     * j 指针可以从末尾下标开始往前搜索，j 下标不会往后走。
     * 第一轮循环：下标 j 一直从大到小搜索，找到下标 j 使得 arr1[i] + arr2[j] <= x
     * 由于是两个数组都是升序排序，所以 arr1[i + 1] >= arr1[i]
     * arr[i + 1] + arr2[j] >= arr1[i] + arr2[j] <= x
     * 可以看出 j 不变的情况下，i 进入下一次循环时，同样满足下标 j 一直从大到小搜索。
     */
    public static void doublePointer(int[] arr1, int[] arr2, int x) {
        for (int i = 0, j = arr2.length - 1; i < arr1.length; i++) {
            // 在 arr2 中找到一个数字，使得 arr1[i] + arr2[j] == x
            while (j > 0 && arr1[i] + arr2[j] > x) j--;
            if (arr1[i] + arr2[j] == x) {
                System.out.println(i + " " + j);
                return;
            }
        }
    }
    
}
