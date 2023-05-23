package alg.leetcode;

import java.util.Stack;

/**
 * @link https://leetcode.cn/problems/implement-queue-using-stacks/
 * @author zhangxq
 * @since 2023/5/23
 */
public class P232ImplementQueueUsingStacks {
    
    public static void main(String[] args) {
    
    }
    
    static
    class MyQueue {
        Stack<Integer> sta1;
        Stack<Integer> sta2;
        public MyQueue() {
            sta1 = new Stack<>();
            sta2 = new Stack<>();
        }
        
        public void push(int x) {
            sta1.push(x);
        }
        
        public int pop() {
            if (sta2.isEmpty()) {
                while (!sta1.isEmpty()) sta2.push(sta1.pop());
            }
            return sta2.pop();
        }
        
        public int peek() {
            if (sta2.isEmpty()) {
                while (!sta1.isEmpty()) sta2.push(sta1.pop());
            }
            return sta2.peek();
        }
        
        public boolean empty() {
            return sta1.isEmpty() && sta2.isEmpty();
        }
    }
}
