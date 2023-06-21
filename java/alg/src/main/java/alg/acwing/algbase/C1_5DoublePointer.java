package alg.acwing.algbase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 双指针
 * @author zhangxq
 * @since 2023/6/20
 */
public class C1_5DoublePointer {
    
    public static void main(String[] args) {
        var solution = new C1_5DoublePointer();
        // solution.bit();
        
        solution.discretization();
    }
    
    // 双指针
    // 最长递增序列问题
    public int doublePointer(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            while (j < arr.length && arr[j] == arr[j - 1] + 1) j++;
            res = Math.max(res, j - i);
            i = j - 1;
        }
        return res;
    }
    // 位运算
    public void bit() {
        System.out.println(-16 >> 3);
        System.out.println(1 << 3);
        System.out.println(-16 >>> 3);
        System.out.println(1 | 0);
        System.out.println(1 & 0);
        System.out.println(1 ^ 0);
        
        int n = 48, k = 3;
        // 求 n 的第 k 位数字
        System.out.println(n >> k & 1);
        // 返回 n 的最后一位 1 和后面的 0 组成的数字：lowbit 方法
        // 1010    返回 10
        // 1010000 返回 10000
        System.out.println(n & -n);
        
        printBinary(48);
        printBinary(-48); // 负数用补码表示，原码 -> 反码 通过每位二进制取反获得，反码再 + 1 得到补码。
        
        System.out.println(countOneBinary(48));
    }
    public void printBinary(int x) {
        for (int k = 31; k >= 0; k--) System.out.print(x >> k & 1);
        System.out.println();
    }
    // 统计数字 k 的二进制表示中 1 出现的次数
    public int countOneBinary(int k) {
        int res = 0;
        while (k != 0) {
            k -= lowbit(k); res++;
        }
        return res;
    }
    public int lowbit(int x) { return x & -x; }
    // 离散化 将一个值域比较大且数字比较少的数组中的值，映射成为数字连续的下标值。
    // 即按照数组中的数字，找出数组中的下标是多少。
    public void discretization() {
        var arr = new int[]{1, 2, 2, 9, 100, 100_000, 1_000_000};
        // 排序
        Arrays.sort(arr);
        // 去重
        var newArr = distinct(arr);
        System.out.println(Arrays.toString(newArr));
        
        System.out.println(find(newArr, 1));
        System.out.println(find(newArr, 2));
        System.out.println(find(newArr, 4));
        System.out.println(find(newArr, 8));
        System.out.println(find(newArr, 100_000));
    }
    // 二分求出 x 对应的离散化的值
    public int find(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) return mid;
            else if (arr[mid] < x) l = mid + 1;
            else r = mid - 1;
        }
        return -1; // 没有找到
    }
    public int[] distinct(int[] arr) {
        var set = new HashSet<>();
        var list = new ArrayList<Integer>();
        for (int x : arr) {
            if (!set.contains(x)) {
                list.add(x);
                set.add(x);
            }
        }
        var res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }
    // 区间合并
}
