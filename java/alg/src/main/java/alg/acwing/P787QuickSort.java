package alg.acwing;

import java.util.Scanner;

/**
 * @author will
 * @since 2024/3/26
 */
public class P787QuickSort {

    static
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            quickSort(arr, 0, n - 1);
            for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");
        }
        public static void quickSort(int[] arr, int l, int r) {
            if (l >= r) return;
            int x = arr[l], i = l - 1, j = r + 1;
            while (i < j) {
                do i++; while (arr[i] < x);
                do j--; while (arr[j] > x);
                if (i < j) swap(arr, i, j);
            }
            quickSort(arr, l, j);
            quickSort(arr, j + 1, r);
        }
        public static void swap(int[] arr, int a, int b) {
            int t = arr[a]; arr[a] = arr[b]; arr[b] = t;
        }
    }
}
