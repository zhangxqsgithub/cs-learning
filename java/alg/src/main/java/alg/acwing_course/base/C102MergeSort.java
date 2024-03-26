package alg.acwing_course.base;

import java.util.Arrays;

/**
 * @author will
 * @since 2024/3/25
 */
public class C102MergeSort {
    
    public static void main(String[] args) {
        var arr = new int[]{3, 1, 4, 2, 5,};
        var solution = new C102MergeSort();
        solution.mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    
    /**
     * 归并排序
     * 核心思想：分治，先分完再递归向上两边，处理排序。与快排不同的是，快排是先排序再递归，而归并则是先递归再排序。
     * 以整个数组的中间数进行分开，分为左部分，一直递归分到只有两个元素。
     * 再将左右两个数组进行排序，排序成一个有序的数组。（合二为一）
     * 归并排序算法是稳定的。（即若数组中存在两个相同的数字，排序后不会改变这两个相同数字的相对位置。）
     * 时间复杂度： nlogn
     */
    public void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
    
    /**
     * 将 arr 的 [l, mid], [mid + 1, r] 的两个部分按序合并起来。
     */
    public void merge(int[] arr, int l, int mid, int r) {
        var tmp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) tmp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        // 复制剩下的部分
        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= r) tmp[k++] = arr[j++];
        for (int p = 0; p < tmp.length; p++) arr[l + p] = tmp[p];
    }
}
