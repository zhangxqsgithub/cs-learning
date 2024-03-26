package alg.acwing;

import java.util.Scanner;

/**
 * @author will
 * @link https://www.acwing.com/problem/content/submission/788/
 * @since 2024/3/26
 */
public class P788NoK {
    
    static
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            nok(arr, 0, n - 1, k);
            System.out.println(arr[k - 1]);
        }
        public static void nok(int[] arr, int l, int r, int k) {
            if (l >= r) return;
            int pivot = arr[l], i = l - 1, j = r + 1;
            while (i < j) {
                do i++; while (arr[i] < pivot);
                do j--; while (arr[j] > pivot);
                if (i < j) swap(arr, i, j);
            }
            // 判断第 k 个数是在哪个区间里，若在前半个区间里，则只排序前半个区间即可。
            if (k <= j + 1) nok(arr, l, j, k);
            else nok(arr, j + 1, r, k);
        }
        public static void swap(int[] arr, int a, int b) {
            int t = arr[a]; arr[a] = arr[b]; arr[b] = t;
        }
    }
}
