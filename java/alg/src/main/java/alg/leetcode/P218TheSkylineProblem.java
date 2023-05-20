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
        var map = new TreeMap<>();
        map.put(2, "c");
        map.put(1, "b");
        map.put(0, "a");
        System.out.println(map);
        
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        /*
            TreeMap 是 key 有序的 Map 数据结构，其中 Entry<K, V> 使用红黑树存储，红黑树
            是一个有序的接近平衡的二叉搜索树。
            其 containsKey、put、get、remove 的时间复杂度为 log(n)
         */
    }
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        var points = new ArrayList<Point>();
        for (var b : buildings) {
            points.add(new Point(b[0], -b[2]));
            points.add(new Point(b[1], b[2]));
        }
        points.sort((a, b) -> {
            if (a.x == b.x) return a.h - b.h;
            else return a.x - b.x;
        });
        var tree = new TreeMap<Integer, Integer>();
        tree.put(0, 0);
        for (var p : points) {
            int x = p.x, h = Math.abs(p.h);
            if (p.h < 0) { // 左端点
                if (h > tree.lastKey()) {
                    var cur = new ArrayList<Integer>();
                    cur.add(x);
                    cur.add(h);
                    res.add(cur);
                }
                tree.put(h, tree.getOrDefault(h, 0) + 1);
            }
            else {
                var cnt = tree.get(h) - 1;
                if (cnt == 0) tree.remove(h);
                else tree.put(h, cnt);
                
                if (h > tree.lastKey()) {
                    var cur = new ArrayList<Integer>();
                    cur.add(x);
                    cur.add(tree.lastKey());
                    res.add(cur);
                }
            }
        }
        return res;
    }
    
    static class Point {
        int x, h;
        
        Point(int x, int h) {
            this.x = x;
            this.h = h;
        }
    }
}
