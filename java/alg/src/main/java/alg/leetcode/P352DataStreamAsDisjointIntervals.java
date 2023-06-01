package alg.leetcode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @link https://leetcode.cn/problems/data-stream-as-disjoint-intervals/
 * @author zhangxq
 * @since 2023/6/1
 */
public class P352DataStreamAsDisjointIntervals {
    
    public static void main(String[] args) {
        var s = new SummaryRanges();
        s.addNum(1);
        s.addNum(3);
        s.addNum(7);
        s.addNum(2);
        s.addNum(6);
    }
    
    static
    class SummaryRanges {
        Set<Pair> set;
        public SummaryRanges() {
            set = new TreeSet<>(Comparator.comparingInt(o -> o.first));
        }
        
        public void addNum(int val) {
            Pair e = null; Pair l = null; Pair r = null;
            for (Pair pair : set) {
                if (pair.first <= val && val <= pair.second) e = pair;
                if (pair.second == val - 1) l = pair;
                if (pair.first == val + 1) r = pair;
            }
            if (e != null) return;
            if (l != null && r != null) { // 左区间和右区间合并
                l.second = r.second;
                set.remove(r);
            }
            // val 自成一个区间
            else if (l == null && r == null) set.add(new Pair(val, val));
            else if (l != null && r == null) l.second = val; // 并到左区间
            else if (l == null && r != null) r.first = val; // 并到右区间
        }
        
        public int[][] getIntervals() {
            var res = new int[set.size()][2];
            int t = 0;
            for (Pair pair : set) {
                res[t][0] = pair.first;
                res[t][1] = pair.second;
                t++;
            }
            return res;
        }
    }
    
    static class Pair {
        int first; int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
