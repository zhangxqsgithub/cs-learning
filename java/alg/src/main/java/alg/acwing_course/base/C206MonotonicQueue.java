package alg.acwing_course.base;

/**
 * @author will
 * @since 2024/4/9
 */
public class C206MonotonicQueue {
    
    public static void main(String[] args) {
    
    }
    
    // 单调队列
    // 找出滑动窗口中的最大值/最小值
    public void monotonicQueue(int[] arr) {
        var q = new int[10_000];
        int n = arr.length;
        int head = 0, tail = -1;
        for (int i = 0; i < n; i ++) {
            while (head <= tail && q[head] != 0) head++;  // 判断队头是否滑出窗口
            while (head <= tail && q[tail] != i) tail--;
            q[++tail] = i;
        }
    }
}
