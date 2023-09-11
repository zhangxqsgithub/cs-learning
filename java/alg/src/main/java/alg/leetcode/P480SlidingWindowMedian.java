package alg.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @link https://leetcode.cn/problems/sliding-window-median/
 * @author zhangxq
 * @since 2023/9/11
 */
public class P480SlidingWindowMedian {
    
    public static void main(String[] args) {
        var solution = new P480SlidingWindowMedian();
        var res1 = solution.medianSlidingWindow(new int[]{2147483647, 2147483647}, 2);
        System.out.println(Arrays.toString(res1));
    }
    
    int k;
    PriorityQueue<Integer> left, right;
    public double[] medianSlidingWindow(int[] nums, int k) {
        this.k = k;
        left = new PriorityQueue<>(Comparator.reverseOrder()); // 大根堆
        right = new PriorityQueue<>(); // 小根堆
        for (int i = 0; i < k; i++) right.add(nums[i]);
        for (int i = 0; i < k / 2; i++) left.add(right.poll());
        double[] res = new double[nums.length - k + 1];
        res[0] = getMedium();
        // 开始滑动窗口
        for (int i = 1; i <= nums.length - k; i++) {
            var addv = nums[i + k - 1];
            var rmv = nums[i - 1];
            if (addv >= right.peek()) right.add(addv);
            else left.add(addv);
            if (rmv >= right.peek()) right.remove(rmv);
            else left.remove(rmv);
            // 平衡左右数字数量
            while (left.size() > right.size()) right.add(left.poll());
            while (right.size() > left.size() + 1) left.add(right.poll());
            res[i] = getMedium();
        }
        return res;
    }
    private double getMedium() {
        if (k % 2 == 1) return right.peek();
        else return ((double) left.peek() + right.peek()) / 2;
    }
}
