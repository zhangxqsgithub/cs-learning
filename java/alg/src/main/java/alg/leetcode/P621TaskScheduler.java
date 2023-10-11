package alg.leetcode;

import java.util.HashMap;

/**
 * @link https://leetcode.cn/problems/task-scheduler/
 * @author zhangxq
 * @since 2023/10/11
 */
public class P621TaskScheduler {
    
    public static void main(String[] args) {
    
    }
    
    public int leastInterval(char[] tasks, int n) {
        var map = new HashMap<Character, Integer>();
        for (var t : tasks) map.put(t, map.getOrDefault(t, 0) + 1);
        int maxc = 0, cnt = 0;
        for (var e : map.entrySet()) maxc = Math.max(maxc, e.getValue());
        for (var e : map.entrySet()) {
            if (e.getValue() == maxc) {
                cnt++;
            }
        }
        return Math.max(tasks.length, (maxc - 1) * (n + 1) + cnt);
    }
    
}
