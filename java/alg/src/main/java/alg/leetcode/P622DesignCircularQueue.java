package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/design-circular-queue/
 * @author zhangxq
 * @since 2023/10/13
 */
public class P622DesignCircularQueue {
    
    public static void main(String[] args) {
    
    }
    
    // 数组模拟队列
    static
    class MyCircularQueue {
        int[] arr;
        int n, h, t;
        public MyCircularQueue(int k) {
            this.arr = new int[k + 1];
            this.n = k + 1;
            this.h = 0;
            this.t = 0;
        }
        public boolean enQueue(int value) {
            if (isFull()) return false;
            arr[t++] = value;
            if (t == n) t = 0;
            return true;
        }
        public boolean deQueue() {
            if (isEmpty()) return false;
            h++;
            if (h == n) h = 0;
            return true;
        }
        public int Front() {
            if (isEmpty()) return -1;
            return arr[h];
        }
        public int Rear() {
            if (isEmpty()) return -1;
            int tail = t - 1;
            if (tail < 0) tail = n - 1;
            return arr[tail];
        }
        public boolean isEmpty() {
            return h == t;
        }
        public boolean isFull() {
            return h == (t + 1) % n;
        }
    }
 
}
