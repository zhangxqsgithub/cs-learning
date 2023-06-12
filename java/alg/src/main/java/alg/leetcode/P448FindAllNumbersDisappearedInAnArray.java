package alg.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/
 * @author zhangxq
 * @since 2023/6/12
 */
public class P448FindAllNumbersDisappearedInAnArray {
    
    public static void main(String[] args) {
        var solution = new P448FindAllNumbersDisappearedInAnArray();
        var nums = new int[]{4,3,2,7,8,2,3,1};
        var res = solution.findDisappearedNumbers(nums);
        System.out.println(res);
    }
    
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 将每个 num 放到 nums[num - 1] 的位置上
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == i + 1) continue;
            if (num == nums[num - 1]) continue;
            while (num != i + 1 && num != nums[num - 1]) {
                int t = nums[i];
                nums[i] = nums[num - 1];
                nums[num - 1] = t;
                num = nums[i];
            }
        }
        // 若数组中每个位置的值不对，则是答案
        var res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                res.add(i + 1);
        return res;
    }
    
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        for (var x : nums) {
            x = Math.abs(x);
            if (nums[x - 1] > 0) nums[x - 1] *= -1;
        }
        var res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0)
                res.add(i + 1);
        return res;
    }
}
