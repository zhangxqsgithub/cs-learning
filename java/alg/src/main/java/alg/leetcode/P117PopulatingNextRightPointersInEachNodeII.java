package alg.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @link https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/
 * @author zhangxq
 * @since 2023/4/27
 */
public class P117PopulatingNextRightPointersInEachNodeII {
    
    public static void main(String[] args) {
    
    }
    
    public Node connect(Node root) {
        var ans = root;
        Queue<Node> que = new LinkedList<>();
        if (root != null) que.add(root);
        while (!que.isEmpty()) {
            var pre = new Node(-1);
            for (int i = que.size(); i > 0; i--) {
                var itm = que.poll();
                if (itm == null) continue;
                pre.next = itm;
                pre = itm;
                if (itm.left != null) que.add(itm.left);
                if (itm.right != null) que.add(itm.right);
            }
        }
        return ans;
    }
    
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
        
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
