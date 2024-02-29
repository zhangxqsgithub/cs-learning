package alg.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @link https://leetcode.cn/problems/course-schedule-iii/
 * @author will
 * @since 2024/2/29
 */
public class P630CourseScheduleIII {
    
    public static void main(String[] args) {
    
    }
    
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        var heap = new PriorityQueue<Integer>((a, b) -> b - a);
        var tot = 0;
        for (var c : courses) {
            tot += c[0];
            heap.add(c[0]);
            if (tot > c[1]) {
                tot -= heap.peek();
                heap.poll();
            }
        }
        return heap.size();
    }
}
