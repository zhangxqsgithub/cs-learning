package alg.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 扫描线问题
 *
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
            // 左端点重合的话，高的在前低的在后；右端点重合的话，低的在前高的在后；左右重合的话，左在前右在后；
            // 若是左端点存负数的高度
            points.add(new Point(b[0], -b[2]));
            // 右端点存正数的高度
            points.add(new Point(b[1], b[2]));
        }
        points.sort((a, b) -> a.x == b.x ? a.h - b.h : a.x - b.x);
        // 保存当前长条内部所有的高度
        var tree = new TreeMap<Integer, Integer>();
        tree.put(0, 0);
        for (var p : points) {
            int x = p.x, h = Math.abs(p.h);
            if (p.h < 0) { // 左端点
                if (h > tree.lastKey()) {
                    res.add(List.of(x, h));
                }
                tree.put(h, tree.getOrDefault(h, 0) + 1);
            }
            else {
                var cnt = tree.get(h) - 1;
                if (cnt == 0) tree.remove(h);
                else tree.put(h, cnt);
                if (h > tree.lastKey()) {
                    res.add(List.of(x, tree.lastKey()));
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
