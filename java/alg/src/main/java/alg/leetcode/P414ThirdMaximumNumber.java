package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/third-maximum-number/
 * @author zhangxq
 * @since 2023/6/9
 */
public class P414ThirdMaximumNumber {
    
    public static void main(String[] args) {
    
    }
    
    public int thirdMax(int[] nums) {
        // s 记录数字出现的个数
        long m1 = Long.MIN_VALUE, m2 = Long.MIN_VALUE, m3 = Long.MIN_VALUE, s = 0;
        for (var x : nums) {
            if (x > m1) { s++; m3 = m2; m2 = m1; m1 = x; }
            else if (x < m1 && x > m2) { s++; m3 = m2; m2 = x; }
            else if (x < m1 && x < m2 && x > m3) { s++; m3 = x; }
        }
        return (int) (s >= 3 ? m3 : m1);
    }
}
