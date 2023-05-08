package alg.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/course-schedule-ii/
 * @since 2023/5/8
 */
public class P210CourseScheduleII {
    
    public static void main(String[] args) {
    
    }
    
    public int[] findOrder(int n, int[][] edges) {
        List<List<Integer>> g = new ArrayList<>();
        for (var i = 0; i < n; i++) g.add(new ArrayList<>());
        int[] d = new int[n];
        for (var e : edges) {
            int b = e[0], a = e[1];
            g.get(a).add(b);
            d[b]++;
        }
        
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (d[i] == 0) que.add(i);
        
        var res = new int[n];
        var cnt = 0;
        while (!que.isEmpty()) {
            var t = que.poll();
            res[cnt++] = t;
            for (var i : g.get(t))
                if (--d[i] == 0) que.add(i);
        }
        return cnt == n ? res : new int[]{};
    }
}
