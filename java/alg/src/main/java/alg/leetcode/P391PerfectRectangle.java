package alg.leetcode;

import java.util.*;

/**
 * @link https://leetcode.cn/problems/perfect-rectangle/
 * @author zhangxq
 * @since 2023/6/6
 */
public class P391PerfectRectangle {
    
    public static void main(String[] args) {
        var solution = new P391PerfectRectangle();
        var rectangles = new int[][]{{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        var res = solution.isRectangleCover(rectangles);
        System.out.println(res);
    }
    
    // 点出现一次或三次
    public boolean isRectangleCover(int[][] rectangles) {
        var map = new HashMap<Pair<Integer, Integer>, Integer>();
        long sum = 0;
        for (var re : rectangles) {
            var a = new Pair<>(re[0], re[1]);
            var b = new Pair<>(re[0], re[3]);
            var c = new Pair<>(re[2], re[3]);
            var d = new Pair<>(re[2], re[1]);
            map.put(a, map.getOrDefault(a, 0) + 1);
            map.put(b, map.getOrDefault(b, 0) + 1);
            map.put(c, map.getOrDefault(c, 0) + 1);
            map.put(d, map.getOrDefault(d, 0) + 1);
            sum += (long) (c.first - a.first) * (c.second - a.second);
        }
        // 查看每一个点出现的次数
        var once = new ArrayList<Pair<Integer, Integer>>();
        for (Map.Entry<Pair<Integer, Integer>, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) once.add(e.getKey());
            else if (e.getValue() == 3) return false;
            else if (e.getValue() > 4) return false;
        }
        if (once.size() != 4) return false;
        long u = Integer.MIN_VALUE, d = Integer.MAX_VALUE, l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        for (Pair<Integer, Integer> p : once) {
            u = Math.max(u, p.second); d = Math.min(d, p.second);
            l = Math.min(l, p.first); r = Math.max(r, p.first);
        }
        return sum == (u - d) * (r - l);
    }
    static class Pair<T1, T2> {
        T1 first;
        T2 second;
        public Pair() { }
        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair<?, ?> pair)) return false;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }
        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
}
