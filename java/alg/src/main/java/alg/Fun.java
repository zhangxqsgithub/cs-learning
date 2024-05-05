package alg;

/**
 * @author zhangxq
 * @since 2023/9/17
 */
public class Fun {
    
    public static int min(int... nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) min = Math.min(min, num);
        return min;
    }
    
    public static int max(int... nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) max = Math.max(max, num);
        return max;
    }
    
    public static void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
    
    /**
     * 返回有序数组 nums 中 <= target 的第一个值
     */
    public static int lowerBound(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
    
    /**
     * 返回有序数组 nums 中 <  target 的第一个值
     */
    public static int upperBound(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
