package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/total-hamming-distance/
 * @author zhangxq
 * @since 2023/9/11
 */
public class P477TotalHammingDistance {
    
    public static void main(String[] args) {
        var solution = new P477TotalHammingDistance();
        
        var res1 = solution.totalHammingDistance(new int[]{4, 14, 2});
        System.out.println(res1);
    }
    
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int zero = 0, one = 0;
            for (var num : nums) {
                if ((num >> i & 1) == 0) zero++;
                else one++;
            }
            res += zero * one;
        }
        return res;
    }
    
    // 暴力求解汉明距离
    public int hammingDistance(int a, int b) {
        int res = 0;
        for (int i = 0; i < 32; i++)
            if ((a >>> i & 1) != (b >>> i & 1))
                res++;
        return res;
    }
    
    // 是用异或运算符求解汉明距离
    public int hammingDistanceByXOR(int a, int b) {
        int x = a ^ b;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (x >> i == 0) break;
            res += (x >> i & 1);
        }
        return res;
    }
}
