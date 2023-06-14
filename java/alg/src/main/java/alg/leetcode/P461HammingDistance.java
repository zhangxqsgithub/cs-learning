package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/hamming-distance/
 * @author zhangxq
 * @since 2023/6/15
 */
public class P461HammingDistance {
    
    public static void main(String[] args) {
    
    }
    
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int res = 0;
        for (int i = 0; i < 32; i++)
            if ((z >> i & 1) == 1)
                res++;
        return res;
    }
}
