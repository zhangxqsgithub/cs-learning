package alg.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/the-skyline-problem/
 * @since 2023/5/9
 */
public class P218TheSkylineProblem {
    
    public static void main(String[] args) {
    
    }
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<Point> points = new ArrayList<>();
        for (int[] b : buildings) {
            points.add(new Point(b[0], -b[2]));
            points.add(new Point(b[1], b[2]));
        }
        points.sort((a, b) -> {
            if (a.x == b.x) return a.h - b.h;
            else return a.x - b.x;
        });
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        tree.put(0, 0);
        for (Point p : points) {
            int x = p.x, h = Math.abs(p.h);
            if (p.h < 0) { // 左端点
                if (h > tree.lastKey()) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(x);
                    cur.add(h);
                    res.add(cur);
                }
                tree.put(h, tree.getOrDefault(h, 0) + 1);
            }
            else {
                int cnt = tree.get(h) - 1;
                if (cnt == 0) tree.remove(h);
                else tree.put(h, cnt);
                
                if (h > tree.lastKey()) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(x);
                    cur.add(tree.lastKey());
                    res.add(cur);
                }
            }
        }
        return res;
    }
    
    class Point {
        int x, h;
        
        Point(int x, int h) {
            this.x = x;
            this.h = h;
        }
    }
}
