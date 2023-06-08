package alg.leetcode;

import java.util.*;

/**
 * @link https://leetcode.cn/problems/random-pick-index/
 * @author zhangxq
 * @since 2023/6/8
 */
public class P398RandomPickIndex {
    
    public static void main(String[] args) {
    
    }
    
    static
    class Solution {
        Map<Integer, List<Integer>> map;
        public Solution(int[] nums) {
            map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (!map.containsKey(nums[i])) map.put(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
            }
        }
        public int pick(int target) {
            if (map.containsKey(target)) {
                Random random = new Random();
                List<Integer> idxs = map.get(target);
                int rand = random.nextInt(idxs.size());
                return idxs.get(rand);
            }
            return -1;
        }
    }
}

