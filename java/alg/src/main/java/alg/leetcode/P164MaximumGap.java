package alg.leetcode;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/maximum-gap/
 * @since 2023/5/7
 */
public class P164MaximumGap {
    
    public static void main(String[] args) {
    
    }
    
    public int maximumGap(int[] nums) {
        var n = nums.length;
        if (n < 2) return 0;
        var min = Integer.MAX_VALUE;
        var max = Integer.MIN_VALUE;
        for (var x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        if (min == max) return 0;
        
        var r = new Range[n - 1];
        for (var i = 0; i < n - 1; i++) r[i] = new Range();
        var len = (max - min + n - 2) / (n - 1);
        for (var x : nums) {
            if (x == min) continue;
            var k = (x - min - 1) / len;
            r[k].used = true;
            r[k].min = Math.min(r[k].min, x);
            r[k].max = Math.max(r[k].max, x);
        }
        var res = 0;
        for (int i = 0, last = min; i < n - 1; i++)
            if (r[i].used) {
                res = Math.max(res, r[i].min - last);
                last = r[i].max;
            }
        return res;
    }
    
    static class Range {
        int min, max;
        boolean used;
        
        public Range() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            used = false;
        }
    }
}
