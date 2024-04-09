package alg.acwing_course.base;

/**
 * @author will
 * @since 2024/4/9
 */
public class C203Stack {
    
    public static void main(String[] args) {
    
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
}
