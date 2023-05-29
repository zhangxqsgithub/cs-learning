package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/range-sum-query-mutable/
 * @author zhangxq
 * @since 2023/5/29
 */
public class P307RangeSumQueryMutable {
    
    public static void main(String[] args) {
        NumArray na = new NumArray(new int[]{1, 3, 5});
        int res1 = na.sumRange(1, 2);
        System.out.println(res1);
    }
    
    /**
     * 利用树状数组解决
     */
    static
    class NumArray {
        int[] nums;
        int n;
        int[] tr;
        public NumArray(int[] nums) {
            this.nums = nums;
            this.n = nums.length;
            this.tr = new int[n + 1];
            for (int i = 0; i < n; i++) add(i + 1, nums[i]);
        }
        
        // 返回二进制表示中的最后一位 1
        private int lowbit(int x) {
            return x & -x;
        }
        
        private int query(int x) {
            int res = 0;
            for (int i = x; i != 0; i -= lowbit(i)) res += tr[i];
            return res;
        }
        
        private void add(int x, int v) {
            for (int i = x; i <= n; i += lowbit(i)) tr[i] += v;
        }
        
        public void update(int i, int val) {
            add(i + 1, val - nums[i]);
            nums[i] = val;
        }
        
        public int sumRange(int left, int right) {
            return query(right + 1) - query(left);
        }
    }
}
