package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/number-of-digit-one/
 * @author zhangxq
 * @since 2023/5/23
 */
public class P233NumberOfDigitOne {
    
    public static void main(String[] args) {
    
    }
    
    public int countDigitOne(int n) {
        var s = String.valueOf(n);
        var nums = new int[s.length()];
        for (var i = 0; i < nums.length; i++) nums[i] = s.charAt(i) - '0';
        var res = 0;
        for (var i = 0; i < nums.length; i++) {
            var d = nums[i];
            int left = 0, right = 0, p = 1;
            for (var j = 0; j < i; j++) left = left * 10 + nums[j];
            for (var j = i + 1; j < nums.length; j++) {
                right = right * 10 + nums[j];
                p *= 10;
            }
            if (d == 0) res += left * p;
            else if (d == 1) res += left * p + right + 1;
            else res += (left + 1) * p;
        }
        return res;
    }
    
}
