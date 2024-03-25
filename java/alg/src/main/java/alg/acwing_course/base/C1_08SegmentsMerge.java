package alg.acwing_course.base;

import alg.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 区间合并
 *
 * @author zhangxq
 * @since 2023/6/23
 */
public class C1_08SegmentsMerge {
    
    public static void main(String[] args) {
        var solution = new C1_08SegmentsMerge();
        var segs = new ArrayList<Pair<Integer, Integer>>();
        segs.add(new Pair<>(1, 2));
        segs.add(new Pair<>(2, 3));
        segs.add(new Pair<>(4, 5));
        segs.add(new Pair<>(7, 10));
        segs.add(new Pair<>(7, 8));
        var res = solution.merge(segs);
        System.out.println(res);
    }
    
    // 区间合并
    // 贪心
    // 1. 区间按照左端点正序排序
    // 2. 从左往右扫描，将可能合并的区间合并
    //    每次维护一个当前的区间 cur，若需要处理的区间 i 的左端点是在 cur 区间内的话，cur 的右端点取 i 的
    //    右端点和 cur 的右端点较大者；
    //    若需要处理的区间 i 的左端点不在当前区间内，则将当前区间赋值为 i 区间；
    public List<Pair<Integer, Integer>> merge(List<Pair<Integer, Integer>> segs) {
        segs.sort(Comparator.comparingInt(Pair::getKey));
        var res = new ArrayList<Pair<Integer, Integer>>();
        // 当前区间在一个不存在的区间内
        int st = Integer.MAX_VALUE, ed = Integer.MIN_VALUE;
        for (var seg : segs) {
            if (ed == Integer.MIN_VALUE || seg.getKey() <= ed) { // 在当前区间内
                st = Math.min(st, seg.getKey());
                ed = Math.max(ed, seg.getValue());
            }
            else { // 找到一个新的区间
                res.add(new Pair<>(st, ed));
                st = seg.getKey(); ed = seg.getValue();
            }
        }
        // 将最后一个区间加入到结果数组
        if (st != Integer.MAX_VALUE) res.add(new Pair<>(st, ed));
        return res;
    }
}
