package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/count-of-smaller-numbers-after-self/
 * @author zhangxq
 * @since 2023/5/30
 */
public class P315CountOfSmallerNumbersAfterSelf {
    
    public static void main(String[] args) {
    
    }
    
    public List<Integer> countSmaller(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int x = nums[i] + 10001;
            res[i] = query(x - 1);
            add(x, 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int re : res) list.add(re);
        return list;
    }
    
    int[] tr = new int[20002];
    int n = 20001;
    public int lowbit(int x) {
        return x & -x;
    }
    public int query(int x) {
        int res = 0;
        for (int i = x; i != 0; i -= lowbit(i)) res += tr[i];
        return res;
    }
    
    public void add(int x, int v) {
        for (int i = x; i <= n; i += lowbit(i)) tr[i] += v;
    }
}
