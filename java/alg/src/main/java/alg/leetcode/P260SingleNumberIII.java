package alg.leetcode;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/single-number-iii/
 * @since 2023/5/25
 */
public class P260SingleNumberIII {
    
    public static void main(String[] args) {
    
    }
    
    public int[] singleNumber(int[] nums) {
        int ab = 0;
        for (var x : nums) ab ^= x;
        
        // 找到第 k 个位置是不一样的（分别是 0 和 1）
        int k = 0;
        while ((ab >> k & 1) == 0) k++;
        int[] res = new int[2];
        res[0] = get(nums, k, 0);
        res[1] = get(nums, k, 1);
        return res;
    }
    
    /**
     * 找出第 k 位 = t 的数
     */
    public int get(int[] nums, int k, int t) {
        int res = 0;
        for (var x : nums)
            if ((x >> k & 1) == t)
                res ^= x;
        return res;
    }
}
