package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/poor-pigs/
 * @author zhangxq
 * @since 2023/6/14
 */
public class P458PoorPigs {
    
    public static void main(String[] args) {
    
    }
    
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int k = minutesToTest / minutesToDie + 1;
        return (int) Math.ceil(Math.log(buckets) / Math.log(k) - 1e-5);
    }
}
