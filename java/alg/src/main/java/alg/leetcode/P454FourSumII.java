package alg.leetcode;

import java.util.HashMap;

/**
 * @link https://leetcode.cn/problems/4sum-ii/
 * @author zhangxq
 * @since 2023/6/13
 */
public class P454FourSumII {
    
    public static void main(String[] args) {
    
    }
    
    public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        var cnt = new HashMap<Integer, Integer>();
        for (var _c : c)
            for (var _d : d)
                cnt.put(_c + _d, cnt.getOrDefault(_c + _d, 0) + 1);
        int res = 0;
        for (var _a : a)
            for (var _b : b)
                res += cnt.getOrDefault(-(_a + _b), 0);
        return res;
    }

}
