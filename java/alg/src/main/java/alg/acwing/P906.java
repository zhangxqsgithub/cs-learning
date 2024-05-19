package alg.acwing;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 区间分组
 *
 * @link https://www.acwing.com/problem/content/908/
 * @author will
 * @since 2024/5/19
 */
public class P906 {
    
    /**
     * 1. 将所有区间按照左端点从小到大排序
     * 2. 从前往后遍历每个区间，判断是否能将其放到某个现有的组内
     *    相当于判断上一个组中所有区间右端点的最大值 maxR，是否小于当前区间左端点 l，
     *    maxR < l 则无需分组；maxR >= l 则需要分组。
     */
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var n = sc.nextInt();
        var intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // 使用小根堆来维护所有组端点的最大值
        var minHeap = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++) {
            int l = intervals[i][0], r = intervals[i][1];
            if (minHeap.isEmpty() || minHeap.peek() >= l) minHeap.add(r);
            else {
                minHeap.poll();
                minHeap.add(r);
            }
        }
        System.out.println(minHeap.size());
    }
}
