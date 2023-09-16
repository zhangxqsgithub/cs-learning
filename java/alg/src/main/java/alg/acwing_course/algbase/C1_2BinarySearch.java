package alg.acwing_course.algbase;

/**
 * 二分
 *
 * @author zhangxq
 * @since 2023/6/19
 */
public class C1_2BinarySearch {
    
    public static void main(String[] args) {
        var solution = new C1_2BinarySearch();
        var arr = new int[]{1, 2, 3, 5, 6, 7, 8, 9};
        // var res = solution.binarySearch(arr, -1);
        // System.out.println(res);
        
        var res = solution.lowerBound(arr, 100_000);
        System.out.println(res);
    }
    
    /**
     * 二分查找 （整数二分、实数二分）
     * 在一个有序数组中查找 target。
     */
    public boolean binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) { // 这里用 l <= r 的原因是内部需要判断 arr[mid] == target
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }
    
    /**
     * 二分查找法, 实现lower_bound
     * 即在一个有序数组arr中, 寻找大于等于target的元素的第一个索引
     * 如果存在, 则返回相应的索引index。否则, 返回arr的元素个数 n
     *
     * 二分查找，l 下标收敛到 >= target 的第一个下标中。
     * 当遇到严格小于 target 的时候，可以直接放弃左半部分的值；
     * 遇到 arr[mid] >= target 的时候说明 arr[mid] 之前可能还有 >= target 值的下标存在，所以设置 r = mid;
     * 这样即使 [l, mid - 1] 之间不存在 >= target 值的下标，arr[mid] 也是满足条件的。
     * 所以，此二分一定收敛到 l = r 或 l + 1 = r 的两种情况中，当 l = r 是就结束了。
     * 情况 1：arr[l] == arr[r] 且 arr[l] >= target; mid 的值为 l; r = mid; 则会收敛到 l = r 的情况。
     * 情况 2：arr[l] < arr[r] 且 arr[l] < target; mid 的值为 l; l = mid + 1; 即 l = r 的情况。
     * 情况 3：arr[l] < arr[r] 且 arr[l] >= target; mid 的值为 l; r = l = mid; 即 l = r 的情况。
     */
    public int lowerBound(int[] arr, int target) {
        // 在 [l, r) 的区间内查找大于等于 target 的第一个索引
        // r 的取值保证了当所有 target > arr 中的所有数字时，可以返回 arr.length 为结果
        int l = 0, r = arr.length;
        while (l != r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < target) l = mid + 1; // 若遇到严格小于目标值的数，则直接略过
            else r = mid; // arr[mid] >= target
        }
        return l;
    }
    
    // 二分查找法, 实现upper_bound
    // 即在一个有序数组arr中, 寻找大于target的元素的第一个索引
    // 如果存在, 则返回相应的索引index
    // 否则, 返回arr的元素个数 n
    public int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l != r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target) l = mid + 1;      // 需要丢弃的区间
            else r = mid; // nums[mid] > target          需要保留的区间
        }
        return l;
    }
}
