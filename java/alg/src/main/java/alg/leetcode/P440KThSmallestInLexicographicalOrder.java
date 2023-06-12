package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/k-th-smallest-in-lexicographical-order/
 * @author zhangxq
 * @since 2023/6/12
 */
public class P440KThSmallestInLexicographicalOrder {
    
    public static void main(String[] args) {
    
    }
    
    public int findKthNumber(int n, int k) {
        int prefix = 1;
        while (k > 1) {
            int cnt = get(prefix, n);
            if (k > cnt) {
                k -= cnt;
                prefix++;
            }
            else {
                k--;
                prefix *= 10;
            }
        }
        return prefix;
    }
    public int get(int prefix, int n) {
        long cur = prefix;
        long next = prefix+1;
        int cnt = 0;
        while(cur <= n){
            cnt += Math.min(n+1, next)-cur;
            cur *= 10;
            next *= 10;
        }
        return cnt;
    }
}
