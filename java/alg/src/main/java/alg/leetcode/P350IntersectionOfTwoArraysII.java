package alg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @link https://leetcode.cn/problems/intersection-of-two-arrays-ii/
 * @author zhangxq
 * @since 2023/6/1
 */
public class P350IntersectionOfTwoArraysII {
    
    public static void main(String[] args) {
    
    }
    
    public int[] intersect(int[] nums1, int[] nums2) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        var l = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                map.put(nums2[i], map.get(nums2[i]) - 1);
                l.add(nums2[i]);
            }
        }
        int[] res = new int[l.size()];
        for (int i = 0; i < l.size(); i++) res[i] = (int) l.get(i);
        return res;
    }
}
