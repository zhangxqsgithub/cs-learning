package alg.acwing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @link https://www.acwing.com/problem/content/790/
 * @author will
 * @since 2024/3/26
 */
public class P788CountReverse {
    
    static
    public class Main {
        static long cnt = 0;
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            mergeSort(arr, 0, arr.length - 1);
            System.out.println(cnt);
        }
        public static void mergeSort(int[] arr, int l, int r) {
            if (l >= r) return;
            var mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
        public static void merge(int[] arr, int l, int mid, int r) {
            var tmp = new int[r - l + 1];
            int i = l, j = mid + 1, k = 0;
            while (i <= mid && j <= r) {
                if (arr[i] <= arr[j]) tmp[k++] = arr[i++];
                /*
                 * 如果 arr[i] > arr[j] 说明 i 和 j 是逆序对；
                 * 也说明 arr[j] 和 arr[i, mid] 都是逆序对；
                 * 则 arr[j] 对应的逆序对数量为 mid - i + 1
                 */
                else {
                    tmp[k++] = arr[j++];
                    cnt += mid - i + 1;
                }
            }
            while (i <= mid) tmp[k++] = arr[i++];
            while (j <= r) tmp[k++] = arr[j++];
            System.arraycopy(tmp, 0, arr, l, tmp.length);
        }
    }
}
