package alg.acwing_course.base;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 离散化
 * 情况：值域比较大，例如 0 ～ 10^9，但是数字的个数比较少。
 * 有些题目，可能将出现的值用作下标来处理。为了节约内存开销，不选择开一个 10^9 长度的数组。
 * 因此将这些数字映射到从 0 开始的连续的多个自然数上。
 * arr[] = {1, 3, 10, 100, 2_000, 50_000}
 * dis[] = {0, 1, 2,  3,   4,     5} // 离散化后数组
 * 1. arr 中可能有重复元素，如何去重？（arr 数组需要去重，若存在重复数字则不能完成一对一映射）
 * 2. 如何快速计算出 arr[i] 离散化后的值是多少？（利用二分算法查找）
 * @author will
 * @since 2024/3/28
 */
public class C108Discretization {
    
    // 离散化 将一个值域比较大且数字比较少的数组中的值，映射成为数字连续的下标值。
    // 即按照数组中的数字，找出数组中的下标是多少。
    public static void main(String[] args) {
        var arr = new int[]{1, 2, 4, 8, 100, 200, 1000};
        var sum = new Sum(arr);
        // 求数组 arr 中的所有数字在区间 [4, 100] 内的总和。
        sum.query(4, 100);
    }
    
    // 例 离散化数组求区间和
    static class Sum {
        List<Integer> list;
        List<Integer> s; // 前缀和数组
        
        public Sum(int[] arr) {
            var l = new ArrayList<Integer>();
            for (int x : arr) l.add(x);
            // 排序 + 去重
            list = l.stream().distinct().sorted().collect(Collectors.toList());
            // 求前缀和数组
            s = new ArrayList<>();
            s.add(0);
            for (int x : arr) s.add(s.get(s.size() - 1) + x);
        }
        
        // 求 [a, b] 数值区间内，存在于 list 数组中的数字总和。
        public int query(int a, int b) {
            int l = find(a), r = find(b);
            int res = get(l, r);
            System.out.println(res);
            return res;
        }
        
        // 二分求出 x 对应的离散化的值
        // 找出第一个 >= x 值的下标
        public int find(int x) {
            int l = 0, r = list.size();
            while (l != r) {
                int mid = l + (r - l) / 2;
                if (list.get(mid) < x) l = mid + 1;
                else r = mid;
            }
            return l;
        }
        
        public int get(int l, int r) {
            l++;
            r++;
            return s.get(r) - s.get(l - 1);
        }
    }
}
