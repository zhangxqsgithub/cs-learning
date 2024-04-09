package alg.acwing_course.base;

/**
 * @author will
 * @since 2024/4/9
 */
public class C204Queue {
    
    public static void main(String[] args) {
    
    }
    
    // 队列
    static class Queue {
        int[] q;
        int head;
        int tail;
        public Queue(int n) {
            q = new int[n];
            head = 0;
            tail = -1;
        }
        public void add(int x) { q[++tail] = x; }
        public int peek() { return q[head]; }
        public int poll() {
            int t = q[head];
            head++;
            return t;
        }
        public boolean empty() {
            return head > tail;
        }
    }
    
    // 循环队列
    static class CircleQueue {
        int[] q;
        int head;
        int tail;
        public CircleQueue(int n) {
            q = new int[n];
            head = 0;
            tail = -1;
        }
        public void add(int x) {
            q[++tail] = x;
            if (tail == q.length) tail = 0;
        }
        public int peek() { return q[head]; }
        public int poll() {
            int t = q[head];
            head++;
            if (head == q.length) head = 0;
            return t;
        }
        public boolean empty() {
            return head == tail;
        }
    }
}
