package alg.acwing_course.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表与邻接表：树与图的存储
 *
 * @author zhangxq
 * @since 2023/6/23
 */
public class C2_01LinkedList {
    
    public static void main(String[] args) {
        var solution = new SingleLinkedList();
        solution.insertFirst(1);
        solution.insertFirst(2);
        solution.removeFirst();
        solution.insertFirst(3);
        solution.insertFirst(4);
        solution.print();
    }
    
    // 使用数组存储元素的单链表
    static class SingleLinkedList {
        int head; // 存储链表头
        List<Integer> elements; // 存储节点值
        List<Integer> next; // 存储节点的 next 指针
        int idx; // 表示当前用到了哪个节点
        public SingleLinkedList() {
            head = -1;
            elements = new ArrayList<>();
            next = new ArrayList<>();
            idx = -1;
        }
        // 在链表头插入一个元素
        public void insertFirst(int num) {
            elements.add(num);
            next.add(head);
            idx++;
            head = idx;
        }
        public void removeFirst() {
            head = next.get(head);
        }
        public void print() {
            var sb = new StringBuilder();
            sb.append("{");
            var h = head;
            while (h != -1) {
                var v = elements.get(h);
                sb.append(v).append("->");
                h = next.get(h);
            }
            sb.append("}");
            System.out.println(sb.toString());
        }
    }
    
    // 用数组存储双连标
    static class DoubleLinkedList {
        static int N = 100010;
        static int[] l = new int[N];
        static int[] r = new int[N];
        static int[] e = new int[N];
        static int idx;
        static void init() {
            r[0] = 1; // 第 0 个位置的右端点在 1
            l[1] = 0; // 第 1 个位置的做断点在 0
            idx = 2; // 此时空位置指向 2
        }
        // 在节点 i 的右边插入一个数 x
        static void add(int i, int x) {
            e[idx] = x;      // 存储值 x
            l[idx] = i;      // 该存储值的左端点是 i
            r[idx] = r[i];   // 该存储值的右端点是 i 的右端点
            l[r[i]] = idx;   // 节点 i 的有端点（原来的有端点）的左端点值为 idx
            r[i] = idx;      // 节点 i 的有端点是 idx
            idx++;           // 指向下一个数组中的空位置
        }
        // 删除节点 i
        static void delete(int i) {
            l[r[i]] = l[i]; // i 的右端点的左端点值为 i 的左端点
            r[l[i]] = r[i]; // i 的左端点的右端点值为 i 的右端点
        }
    }
    
    // 用数组实现栈
    static class Stack {
        int idx;
        int[] stack;
        public Stack(int n) {
            idx = -1;
            stack = new int[n];
        }
        public void push(int x) {
            stack[++idx] = x;
        }
        public int peek() {
            return stack[idx];
        }
        public int pop() {
            int t = stack[idx];
            idx--;
            return t;
        }
        public boolean empty() {
            return idx < 0;
        }
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
    
    // 单调栈
    // 找出每个数左边离它最近的比它大/小的数
    public void monotonicStack(int[] arr) {
        Stack stk = new Stack(1000);
        stk.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            while (!stk.empty() && stk.pop() < cur) {}
            stk.push(cur);
        }
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
    
    // 字符串 hash
    public long strHash(String str) {
        int P = 13331;
        int n = str.length();
        var h = new long[n];
        var p = new long[n];
        p[0] = 1;
        for (int i = 1; i < n; i++) {
            h[i] = h[i - 1] * P + str.charAt(i);
            p[i] = p[i - 1] * P;
        }
        
        int l = 0, r = str.length() - 1;
        return h[r] - h[l - 1] * p[r - l + 1];
    }
}
