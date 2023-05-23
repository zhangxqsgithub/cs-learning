package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/implement-stack-using-queues/
 * @author zhangxq
 * @since 2023/5/23
 */
public class P225ImplementStackUsingQueues {
    
    static
    class MyStack {
        List<Integer> list;
        public MyStack() {
            list = new ArrayList<>();
        }
        
        public void push(int x) {
            list.add(x);
        }
        
        public int pop() {
            int res = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return res;
        }
        
        public int top() {
            return list.get(list.size() - 1);
        }
        
        public boolean empty() {
            return list.isEmpty();
        }
    }
}
