package alg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @link https://leetcode.cn/problems/minimum-index-sum-of-two-lists/
 * @author zhangxq
 * @since 2023/10/1
 */
public class P599MinimumIndexSumOfTwoLists {
    
    public static void main(String[] args) {
    
    }
    
    public String[] findRestaurant(String[] list1, String[] list2) {
        var map = new HashMap<String, Integer>();
        for (int i = 0; i < list1.length; i++) map.put(list1[i], i);
        int sum = Integer.MAX_VALUE;
        var res = new ArrayList<String>();
        for (int i = 0; i < list2.length; i++) {
            var s = list2[i];
            if (map.containsKey(s)) {
                int k = i + map.get(s);
                if (k < sum) {
                    sum = k;
                    res = new ArrayList<>();
                    res.add(s);
                }
                else if (k == sum) {
                    res.add(s);
                }
            }
        }
        return res.toArray(new String[0]);
    }
}
