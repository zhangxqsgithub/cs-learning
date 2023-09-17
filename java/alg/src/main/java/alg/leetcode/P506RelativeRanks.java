package alg.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @link https://leetcode.cn/problems/relative-ranks/
 * @author zhangxq
 * @since 2023/9/17
 */
public class P506RelativeRanks {
    
    public static void main(String[] args) {
        var solution = new P506RelativeRanks();
        var res1 = solution.findRelativeRanks(new int[]{5,4,3,2,1});
        System.out.println(Arrays.toString(res1));
    }
    
    public String[] findRelativeRanks(int[] score) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < score.length; i++) map.put(score[i], i);
        
        var res = new String[score.length];
        Arrays.sort(score);
        for (int i = score.length - 1, j = 1; i >= 0; i--, j++) {
            var s = score[i];
            var k = map.get(s);
            var rank = switch(j) {
                case 1 -> "Gold Medal";
                case 2 -> "Silver Medal";
                case 3 -> "Bronze Medal";
                default -> j + "";
            };
            res[k] = rank;
        }
        
        return res;
    }
    
}
