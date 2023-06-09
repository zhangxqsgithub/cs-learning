package alg.leetcode;

import java.util.Arrays;
import java.util.BitSet;
import java.util.PrimitiveIterator;

/**
 * @link https://leetcode.cn/problems/partition-equal-subset-sum/
 * @author zhangxq
 * @since 2023/6/9
 */
public class P416PartitionEqualSubsetSum {
    
    public static void main(String[] args) {
        var solution = new P416PartitionEqualSubsetSum();
        var res = solution.canPartition2(new int[]{1, 5, 11, 5});
        System.out.println(res);
    }
    
    // 背包问题
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (var x : nums) sum += x;
        if (sum % 2 != 0) return false;
        sum /= 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1; // 表示能够拼凑出来
        for (var x : nums) {
            for (int j = sum; j >= x; j--) {
                dp[j] |= dp[j - x];
            }
        }
        return dp[sum] != 0;
    }
    
    // 优化 对代码做等价变形 (这段代码没有过)
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        var dp = new BitSet(10001);
        dp.set(0, true);
        for (var x : nums) {
            // 要实现 dp = dp | dp << x;
            dp.or(moveRight(dp, x));
            sum += x;
        }
        if (sum % 2 != 0) return false;
        return dp.get(sum / 2);
    }
    public BitSet moveRight(BitSet bs, int m) {
        int n = bs.size() - m;
        BitSet res = new BitSet(n);
        var iterator = bs.stream().iterator();
        while (iterator.hasNext()) {
            var i = iterator.next();
            res.set(i + m);
        }
        return res;
    }
}
