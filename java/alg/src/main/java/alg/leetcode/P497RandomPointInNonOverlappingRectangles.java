package alg.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles/
 * @since 2023/9/14
 */
public class P497RandomPointInNonOverlappingRectangles {
    
    public static void main(String[] args) {
    }
    
    static
    class Solution {
        int[][] rects;
        int n;
        // 前缀和数组
        List<Integer> s = new ArrayList<>();
        Random rand = new Random();
        public Solution(int[][] rects) {
            this.rects = rects;
            this.n = rects.length;
            s.add(0);
            for (var r : rects) {
                int dx = r[2] - r[0] + 1;
                int dy = r[3] - r[1] + 1;
                // 在前一个点的基础上加上当前矩形的面积
                s.add(s.get(s.size() - 1) + dx * dy);
            }
        }
        public int[] pick() {
            int k = rand.nextInt(s.get(s.size() - 1)) + 1;
            // 二分查找 k 在哪个区间
            int l = 1, r = n;
            while (l < r) {
                int mid = l + r >> 1;
                if (s.get(mid) >= k) r = mid;
                else l = mid + 1;
            }
            var t = rects[r - 1];
            int dx = t[2] - t[0] + 1;
            int dy = t[3] - t[1] + 1;
            return new int[]{rand.nextInt(dx) + t[0], rand.nextInt(dy) + t[1],};
        }
    }
}
