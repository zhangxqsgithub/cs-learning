package alg;

/**
 * @author zhangxq
 * @since 2023/9/16
 */
public class BinarySearch {
    
    public static void main(String[] args) {
        var solution = new BinarySearch();
        var nums = new int[]{1, 2, 4, 6, 99, 100, 120, 140, 199, 358, 999, 1001};
        for (int i = 0; i < 2_000; i++) {
            var res = solution.bs2(nums, i);
            System.out.println(i + ":" + res);
            assert res == -1 || i == nums[res];
        }
    }
    
    public int bs(int[] nums, int target) {
        // [l, r] 左闭右闭
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
    
    public int bs2(int[] nums, int target) {
        // [l, r) 左闭右开
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        return -1;
    }
}
