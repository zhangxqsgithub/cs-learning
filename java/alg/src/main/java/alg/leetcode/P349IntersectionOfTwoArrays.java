package alg.leetcode;

import java.util.*;

/**
 * @link https://leetcode.cn/problems/intersection-of-two-arrays/
 * @author zhangxq
 * @since 2023/6/1
 */
public class P349IntersectionOfTwoArrays {
    
    public static void main(String[] args) {
        var solution = new P349IntersectionOfTwoArrays();
        var nums1 = new int[]{1, 2, 2, 1,};
        var nums2 = new int[]{2, 2,};
        var res = solution.intersection(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
    
    public int[] intersection(int[] nums1, int[] nums2) {
        var set = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) set.add(nums1[i]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                set.remove(nums2[i]);
                list.add(nums2[i]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
