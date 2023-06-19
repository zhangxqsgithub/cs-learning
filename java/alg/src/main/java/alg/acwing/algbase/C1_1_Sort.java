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
        // solution.quickSort2(arr, 0, arr.length - 1);
        // System.out.println(Arrays.toString(arr));
        
        solution.mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    
    /**
     * 快排
     *
     * 核心思想：分治。
     * 如何分治？设立一个分界点 x，我们需要把分界点放到排序好的位置上，也就是说利用分界点 x 将数组分为两部分，前半
     * 部分是 <= x 的数，后半部分是 >= x 的数。然后递归地将左半部分和右半部分分别排序。
     * 当需要排序的数字只剩下一个的时候，就是结束条件，即当需要排序的数组只有一个元素的时候是不需要排序的。
     *
     * 方法
     * 1. 额外空间法，申请两个数组，一个存放 >= pivot 的数，一个存放 <= pivot 的数，完成之后将两个数组合并到原
     * 数组中。
     * 2. 双指针法，前后指针 i 和 j 同时往前走，前面指针直到遇到 > x 的数停止，有面指针遇到 < x 的数停止，若前面指针比后
     * 面指针小，则交换两个值。[l, i - 1] 区间是 <= x 的数，[j + 1, r] 区间是 >= x 的数。
     * 3. 三指针法，将数组分为三个部分，[l, lt] 是严格小于 x 的区间，[lt + 1, i] 是等于 x 的区间，[gt, r] 是
     * 严格大于 x 的区间。
     * 定义好 lt、i、gt 三个参数即可。
     */
    public void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int pivot = arr[l]; // 分界点
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
    
    // 代码简洁！
    public void quickSort2(int[] arr, int l, int r) {
        if (l >= r) return;
        int pivot = arr[l];
        int i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (arr[i] < pivot); // i 指针会停在 <= pivot 的数字上
            do j--; while (arr[j] > pivot); // j 指针会停在 >= pivot 的数字上
            if (i < j) swap(arr, i, j);
        }
        // 这里要取 j 的原因是，若取 i，则会死循环例 [1, 2]
        quickSort2(arr, l, j);
        quickSort2(arr, j + 1, r);
    }
    
    /**
     * 归并排序
     * 核心思想：分治，先分完再递归向上两边，处理排序。与快排不同的是，快排是先排序再递归，而归并则是先递归再排序。
     * 以整个数组的中间数进行分开，分为左部分，一直递归分到只有两个元素。
     * 再将左右两个数组进行排序，排序成一个有序的数组。（合二为一）
     * 归并排序算法是稳定的。（即若数组中存在两个相同的数字，排序后不会改变这两个相同数字的相对位置。）
     */
    public void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
    
    public void merge(int[] arr, int l, int mid, int r) {
        var tmp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) tmp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= r) tmp[k++] = arr[j++];
        for (int p = 0; p < tmp.length; p++) arr[l + p] = tmp[p];
    }
    
    public void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
