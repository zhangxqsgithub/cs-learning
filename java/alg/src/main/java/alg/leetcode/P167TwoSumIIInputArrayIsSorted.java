package alg.leetcode;

/**
 * 两数之和 II - 输入有序数组
 *
 * @link https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 * @author zhangxq
 * @since 2023/5/7
 */
public class P167TwoSumIIInputArrayIsSorted {
    
    public static void main(String[] args) {
    
    }
    
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, j = numbers.length - 1; i < j; i++) {
            while (i < j && numbers[i] + numbers[j] > target) j--;
            if (i < j && numbers[i] + numbers[j] == target)
                return new int[]{i + 1, j + 1};
        }
        return null;
    }
}
