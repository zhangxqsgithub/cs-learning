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
    
    /* 二分查找（双闭区间） */
    int binarySearch(int[] nums, int target) {
        // 初始化双闭区间 [0, n-1] ，即 i, j 分别指向数组首元素、尾元素
        int i = 0, j = nums.length - 1;
        // 循环，当搜索区间为空时跳出（当 i > j 时为空）
        while (i <= j) {
            int m = i + (j - i) / 2;      // 计算中点索引 m
            if (nums[m] < target)         // 此情况说明 target 在区间 [m+1, j] 中
                i = m + 1;
            else if (nums[m] > target)    // 此情况说明 target 在区间 [i, m-1] 中
                j = m - 1;
            else                          // 找到目标元素，返回其索引
                return m;
        } // 未找到目标元素，返回 -1
        return -1;
    }
    
    /* 二分查找（左闭右开） */
    int binarySearchLCRO(int[] nums, int target) {
        // 初始化左闭右开 [0, n) ，即 i, j 分别指向数组首元素、尾元素 +1
        int i = 0, j = nums.length;
        // 循环，当搜索区间为空时跳出（当 i = j 时为空）
        while (i < j) {
            int m = i + (j - i) / 2;    // 计算中点索引 m
            if (nums[m] < target)       // 此情况说明 target 在区间 [m+1, j) 中
                i = m + 1;
            else if (nums[m] > target)  // 此情况说明 target 在区间 [i, m) 中
                j = m;
            else                        // 找到目标元素，返回其索引
                return m;
        }
        // 未找到目标元素，返回 -1
        return -1;
    }
    
    /* 二分查找插入点（无重复元素） */
    int binarySearchInsertionSimple(int[] nums, int target) {
        int l = 0, r = nums.length - 1; // 初始化双闭区间 [0, n-1]
        while (l <= r) {
            int m = l + (r - l) / 2;  // 计算中点索引 m
            if (nums[m] < target) {
                l = m + 1;            // target 在区间 [m+1, j] 中
            }
            else if (nums[m] > target) {
                r = m - 1;            // target 在区间 [i, m-1] 中
            }
            else {
                return m;             // 找到 target ，返回插入点 m
            }
        }
        // 未找到 target ，返回插入点 l
        // 下标 l 会指向 >= target 的第一个数字
        // 下标 r 会指向 <= target 的最后一个数字
        return l;
    }
}
