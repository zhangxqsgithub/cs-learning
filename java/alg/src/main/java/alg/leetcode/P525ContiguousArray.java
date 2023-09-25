package alg.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @link https://leetcode.cn/problems/contiguous-array/
 * @author zhangxq
 * @since 2023/9/25
 */
public class P525ContiguousArray {
    
    public static void main(String[] args) {
    
    }
    
    /**
     *
     */
    public int findMaxLength(int[] nums) {
        var n = nums.length;
        // 记录 1 的个数 - 0 的个数的差（即当作 -1，1 当作 1，数组的和）
        // var s = new int[n + 1];
        // for (int i = 1; i <= n; i++) s[i] = s[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
        
        int res = 0;
        // 存储 1 的个数 - 0 的个数的差，值的最小下标
        var map = new HashMap<Integer, Integer>();
        map.put(0, 0);
        for (int i = 1, zero = 0, one = 0; i <= n; i++) {
            int num = nums[i - 1];
            if (num == 0) zero++; else one++;
            int x = one - zero;
            if (!map.containsKey(x)) map.put(x, i);
            else res = Math.max(res, i - map.get(x));
        }
        return res;
    }
    
    // 暴力求解
    public int findMaxLength1(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int zero = 0;
            int one = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) zero++; else one++;
                if (zero == one) res = Math.max(res, j - i + 1);
            }
        }
        return res;
    }
}
