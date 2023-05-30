package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/create-maximum-number/
 * @author zhangxq
 * @since 2023/5/30
 */
public class P321CreateMaximumNumber {
    
    public static void main(String[] args) {
    
    }
    
    public int[] maxNumber(int[] A, int[] B, int k) {
        int[] res = null;
        
        for (int l = Math.max(0, k - B.length); l <= Math.min(A.length, k); ++l) {
            int[] a = maxSubSeq(A, l);
            int[] b = maxSubSeq(B, k - l);
            int[] c = merge(a, b);
            if (res == null || greater(c, 0, res, 0))
                res = c;
        }
        return res;
    }
    
    private int[] maxSubSeq(int[] nums, int k) {
        int n = nums.length;
        int[] stk = new int[k];
        int j = -1;
        for (int i = 0; i < n; ++i) {
            while (j >= 0 && stk[j] < nums[i] && j + n - i >= k) j--;
            if (j < k - 1) stk[++j] = nums[i];
        }
        return stk;
    }
    
    private int[] merge(int[] a, int[] b) {
        int m = a.length, n = b.length;
        int[] ans = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (greater(a, i, b, j)) ans[k++] = a[i++];
            else ans[k++] = b[j++];
        }
        while (i < m) ans[k++] = a[i++];
        while (j < n) ans[k++] = b[j++];
        return ans;
    }
    
    private boolean greater(int[] a, int i, int[] b, int j) {
        int m = a.length, n = b.length;
        while (i < m && j < n && a[i] == b[j]) { i++; j++; }
        return j == n || (i < m && a[i] > b[j]);
    }
}
