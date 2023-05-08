package alg.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/course-schedule/
 * @since 2023/5/8
 */
public class P207CourseSchedule {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 有向图求拓扑排序的问题
     */
    public boolean canFinish(int n, int[][] edges) {
        // 邻接表
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        // 每个点的入度
        int[] d = new int[n];
        for (var e : edges) {
            var a = e[0];
            var b = e[1];
            g.get(a).add(b);
            d[b]++;
        }
        
        Queue<Integer> que = new LinkedList<>();
        for (var i = 0; i < n; i++) {
            // 若入度为 0，说明可以从当前点遍历
            if (d[i] == 0) que.add(i);
        }
        
        // 记录遍历节点的数量
        var cnt = 0;
        // 遍历
        while (!que.isEmpty()) {
            var t = que.poll();
            cnt++;
            for (var i : g.get(t))
                if (--d[i] == 0)
                    que.add(i);
        }
        
        return cnt == n;
    }
    
}
