package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/flatten-a-multilevel-doubly-linked-list/
 * @author zhangxq
 * @since 2023/6/9
 */
public class P430FlattenAMultilevelDoublyLinkedList {
    
    public static void main(String[] args) {
    
    }
    
    public Node flatten(Node head) {
        var res = dfs(head);
        return res[0];
    }
    public Node[] dfs(Node head) {
        if (head == null) return new Node[]{null, null};
        Node cur = head, tail = head; // 最后一个出现的不为空的点
        while (cur != null) {
            tail = cur;
            if (cur.child != null) {
                var t = dfs(cur.child);
                cur.child = null;
                t[1].next = cur.next;
                if (cur.next != null) cur.next.prev = t[1];
                cur.next = t[0];
                t[0].prev = cur;
                cur = t[1].next;
                tail = t[1];
            }
            else {
                cur = cur.next;
            }
        }
        return new Node[]{head, tail};
    }
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
