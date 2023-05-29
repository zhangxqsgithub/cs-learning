package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/minimum-height-trees/
 * @author zhangxq
 * @since 2023/5/29
 */
public class P310MinimumHeightTrees {
    
    public static void main(String[] args) {
        P310MinimumHeightTrees solution = new P310MinimumHeightTrees();
        List<Integer> res1 = solution.findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}});
        System.out.println(res1);
    }
    
    List<List<Integer>> g;
    int[] d1; int[] d2; int[] p1; int[] p2; int[] up;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        g = new ArrayList<>(); for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        d1 = new int[n]; d2 = new int[n]; p1 = new int[n]; p2 = new int[n]; up = new int[n];
        for (var e : edges) {
            int a = e[0], b = e[1];
            g.get(a).add(b); g.get(b).add(a);
        }
        dfs1(0, -1);
        dfs2(0, -1);
        
        // 求最小值
        int mind = n + 1;
        for (int i = 0; i < n; i++) mind = Math.min(mind, Math.max(up[i], d1[i]));
        // 将结果保存
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (Math.max(up[i], d1[i]) == mind)
                res.add(i);
        return res;
    }
    
    public void dfs1(int u, int father) {
        for (var x : g.get(u)) {
            if (x == father) continue;
            dfs1(x, u);
            // 维护最大值和次大值的
            int d = d1[x] + 1;
            if (d >= d1[u]) {
                d2[u] = d1[u]; d1[u] = d;
                p2[u] = p1[u]; p1[u] = x;
            }
            else if (d > d2[u]) {
                d2[u] = d;
                p2[u] = x;
            }
        }
    }
    
    public void dfs2(int u, int father) {
        for (var x : g.get(u)) {
            if (x == father) continue;
            if (p1[u] == x) up[x] = Math.max(up[u], d2[u]) + 1;
            else up[x] = Math.max(up[u], d1[u]) + 1;
            dfs2(x, u);
        }
    }
}
