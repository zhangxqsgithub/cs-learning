package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/h-index-ii/
 * @author zhangxq
 * @since 2023/5/25
 */
public class P275HIndexII {
    
    public static void main(String[] args) {
    
    }
    
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (citations[n - mid] >= mid) l = mid;
            else r = mid - 1;
        }
        return r;
    }
}
