package alg.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/largest-number/
 * @author zhangxq
 * @since 2023/5/8
 */
public class P179LargestNumber {
    
    public static void main(String[] args) {
    }
    
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) arr[i] = String.valueOf(nums[i]);
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        if (arr[0].equals("0")) return "0";
        return String.join("", arr);
    }
    
}
