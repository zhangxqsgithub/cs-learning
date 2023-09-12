package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/max-consecutive-ones/
 * @author zhangxq
 * @since 2023/9/12
 */
public class P485MaxConsecutiveOnes {
    
    public static void main(String[] args) {
    
    }
    
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != 1) continue;
            // 找出连续的 1
            int m = 0;
            for (int j = i; j < nums.length && nums[j] == 1; j++) m++;
            max = Math.max(max, m);
        }
        return max;
    }
    
    public int findMaxConsecutiveOnes2(int[] nums) {
        int cnt = 0, max = 0;
        for (int num : nums) {
            if (num == 1) cnt++;
            else {
                max = Math.max(max, cnt);
                cnt = 0;
            }
        }
        max = Math.max(max, cnt);
        return max;
    }
}
