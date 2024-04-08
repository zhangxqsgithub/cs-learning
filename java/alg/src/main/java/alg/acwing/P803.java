package alg.acwing;

import alg.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 区间合并
 * @link https://www.acwing.com/problem/content/805/
 * @author will
 * @since 2024/4/8
 */
public class P803 {
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        var segs = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < n; i++) {
            int first = sc.nextInt(), second = sc.nextInt();
            segs.add(new Pair<>(first, second));
        }
        var res = mergeSegments(segs);
        System.out.println(res.size());
    }
    
    /**
     * 合并区间
     */
    public static List<Pair<Integer, Integer>> mergeSegments(List<Pair<Integer, Integer>> segs) {
        // 1. 先根据第一个元素进行自然排序
        segs.sort(Comparator.comparingInt(Pair::getFirst));
        // 2. 定义当前正在处理的区间
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        var res = new ArrayList<Pair<Integer, Integer>>();
        for (var seg : segs) {
            // seg 在当前区间内
            if (r == Integer.MIN_VALUE || seg.getFirst() <= r) {
                l = Math.min(l, seg.getFirst());
                r = Math.max(r, seg.getSecond());
            }
            // 不在当前区间内
            else {
                res.add(new Pair<>(l, r));
                l = seg.getFirst();
                r = seg.getSecond();
            }
        }
        if (r != Integer.MIN_VALUE) res.add(new Pair<>(l, r));
        return res;
    }
}
