package alg;

import java.util.Arrays;

public class MergeSort {
    
    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] arr1 = {3, 4, 2, 1, 5, 9};
        sort.mergeSort(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
    }
    
    /**
     * 归并排序
     */
    public void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r); // 合二为一
    }
    
    /**
     * 两个有序的数组合并为一个有序数组
     */
    private void merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1]; // 中间数组
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];
        for (int p = 0; p < temp.length; ++p) arr[l + p] = temp[p];
    }
    
}
