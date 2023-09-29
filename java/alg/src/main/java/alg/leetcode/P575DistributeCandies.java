package alg.leetcode;

import java.util.HashSet;

/**
 * @link https://leetcode.cn/problems/distribute-candies/
 * @author zhangxq
 * @since 2023/9/29
 */
public class P575DistributeCandies {
    
    public static void main(String[] args) {
    
    }
    
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        var set = new HashSet<Integer>();
        for (var x : candyType) set.add(x);
        return Math.min(set.size(), n / 2);
    }
}


