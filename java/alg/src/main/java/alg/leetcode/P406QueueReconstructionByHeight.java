package alg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/queue-reconstruction-by-height/
 * @author zhangxq
 * @since 2023/6/8
 */
public class P406QueueReconstructionByHeight {
    
    public static void main(String[] args) {
    
    }
    
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1,o2) -> {
            if(o1[0] != o2[0]) return o2[0]-o1[0];
            return o1[1]-o2[1];
        });
        List<int[]> list = new ArrayList<>();
        for(int[] p: people){ list.add(p[1],p); }
        return list.toArray(new int[0][0]);
    }
}
