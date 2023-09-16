package alg;

/**
 * @author zhangxq
 * @since 2023/9/16
 */
public class BinarySearch {
    
    public static void main(String[] args) {
        var solution = new BinarySearch();
        var nums = new int[]{1, 2, 4, 6, 99, 100, 120, 140, 199, 358, 999};
        for (int i = 0; i < 1000; i++) {
            var res = solution.bs(nums, i);
            System.out.println(i + ":" + res);
            assert res == -1 || i == nums[res];
        }
    }
    
    public int bs(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}
