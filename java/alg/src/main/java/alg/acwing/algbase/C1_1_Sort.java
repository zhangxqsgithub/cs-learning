package alg.acwing.algbase;

import java.util.Arrays;

/**
 * @author zhangxq
 * @since 2023/6/16
 */
public class C1_1_Sort {
    
    public static void main(String[] args) {
        var solution = new C1_1_Sort();
        var arr = new int[]{3, 1, 4, 2, 5,};
        solution.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    
    // 快排
    public void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int pivot = arr[l];
        int lt = l, i = l + 1, gt = r + 1;
        while (i < gt) {
            if (arr[i] < pivot) {
                swap(arr, i, ++lt);
                i++;
            }
            else if (arr[i] > pivot) swap(arr, i, --gt);
            else i++;
        }
        swap(arr, l, lt);
        quickSort(arr, l, lt - 1);
        quickSort(arr, gt, r);
    }
    
    // 归并排序
    public void mergeSort() {
    
    }
    
    public void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
