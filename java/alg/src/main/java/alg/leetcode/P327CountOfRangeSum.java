package alg.leetcode;

import java.util.*;

/**
 * @link https://leetcode.cn/problems/count-of-range-sum/
 * @author zhangxq
 * @since 2023/5/30
 */
public class P327CountOfRangeSum {
    
    public static void main(String[] args) {
    
    }
    
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] s = new long[n + 1]; // 前缀和数组
        Set<Long> set = new TreeSet<>();
        set.add(0L);
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + nums[i - 1];
            set.add(s[i]);
            set.add(s[i] - lower);
            set.add(s[i] - upper - 1);
        }
        Map<Long, Integer> idx = new HashMap<>();
        int t = 1;
        for (long num : set) { idx.put(num, t++); }
        
        this.m = set.size();
        this.tr = new int[m + 1];
        
        int res = 0;
        add(idx.get(0L), 1);
        for (int i = 1; i <= n; i++) {
            res += query(idx.get(s[i] - lower)) - query(idx.get(s[i] - upper - 1));
            add(idx.get(s[i]), 1);
        }
        return res;
    }
    
    int m;
    int[] tr;
    public int lowbit(int x) {
        return x & -x;
    }
    public int query(int x) {
        int res = 0;
        for (int i = x; i != 0; i -= lowbit(i)) res += tr[i];
        return res;
    }
    public void add(int x, int v) {
        for (int i = x; i <= m; i += lowbit(i)) tr[i] += v;
    }
    
}
