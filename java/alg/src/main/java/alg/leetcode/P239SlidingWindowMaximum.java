package alg.leetcode;

import java.util.*;

/**
 * @link https://leetcode.cn/problems/sliding-window-maximum/
 * @author zhangxq
 * @since 2023/5/23
 */
public class P239SlidingWindowMaximum {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 单调队列的解法
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && i - k + 1 > q.peekFirst()) q.pollFirst();
            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) q.pollLast();
            q.add(i);
            if (i >= k - 1) res.add(nums[q.peekFirst()]);
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) arr[i] = res.get(i);
        return arr;
    }

}
