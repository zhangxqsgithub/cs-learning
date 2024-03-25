package alg.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/exclusive-time-of-functions/
 * @author will
 * @since 2024/3/25
 */
public class P636ExclusiveTimeOfFunctions {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 0:start:3
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        var res = new int[n];
        var stack = new LinkedList<Integer>();
        var last = 0; // 记录最后执行时间戳
        for (var log : logs) {
            var r = getR(log);
            if (r.isStart()) {
                if (!stack.isEmpty()) res[stack.peek()] += r.timestamp - last;
                stack.push(r.id);
                last = r.timestamp;
            }
            if (r.isEnd()) {
                res[stack.peek()] += r.timestamp - last + 1;
                stack.pop();
                last = r.timestamp + 1;
            }
        }
        return res;
    }
    
    public record R(int id, String action, int timestamp) {
        public boolean isStart() { return "start".equals(action); }
        public boolean isEnd() { return "end".equals(action); }
    }
    public R getR(String str) {
        var id = Integer.parseInt(str.substring(0, str.indexOf(':')));
        var action = str.substring(str.indexOf(':') + 1, str.lastIndexOf(':'));
        var timestamp = Integer.parseInt(str.substring(str.lastIndexOf(':') + 1));
        return new R(id, action, timestamp);
    }
}
