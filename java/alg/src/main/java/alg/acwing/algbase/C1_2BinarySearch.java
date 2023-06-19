package alg.acwing.algbase;

/**
 * @author zhangxq
 * @since 2023/6/19
 */
public class C1_2BinarySearch {
    
    public static void main(String[] args) {
        var solution = new C1_2BinarySearch();
        var arr = new int[]{1, 2, 3, 5, 6, 7, 8, 9};
        // var res = solution.binarySearch(arr, -1);
        // System.out.println(res);
        
        var res = solution.lowerBound(arr, 4);
        System.out.println(res);
    }
    
    /**
     * 二分查找 （整数二分、实数二分）
     * 在一个有序数组中查找 target。
     */
    public boolean binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }
    
    // 二分查找法, 在有序数组arr中, 查找target
    // 如果找到target, 返回第一个target相应的索引index
    // 如果没有找到target, 返回比target小的最大值相应的索引, 如果这个最大值有多个, 返回最大索引
    // 如果这个target比整个数组的最小元素值还要小, 则不存在这个target的floor值, 返回-1
    public int floor(int[] arr, int target) {
        return -1;
    }
    
    // 二分查找法, 在有序数组arr中, 查找target
    // 如果找到target, 返回最后一个target相应的索引index
    // 如果没有找到target, 返回比target大的最小值相应的索引, 如果这个最小值有多个, 返回最小的索引
    // 如果这个target比整个数组的最大元素值还要大, 则不存在这个target的ceil值, 返回整个数组元素个数n
    public int ceil(int[] arr, int target) {
        return -1;
    }
    
    // 二分查找法, 实现lower_bound
    // 即在一个有序数组arr中, 寻找大于等于target的元素的第一个索引
    // 如果存在, 则返回相应的索引index
    // 否则, 返回arr的元素个数 n
    public int lowerBound(int[] arr, int target) {
        // 在 [l, r) 的区间内查找大于等于 target 的第一个索引
        int l = 0, r = arr.length; // r 的取值保证了奇数时取到中间值，偶数时取到中间两个数靠右的值。
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
            if (arr[mid] <= target) l = mid + 1;
            else r = mid; // nums[mid] > target
        }
        return l;
    }
}
