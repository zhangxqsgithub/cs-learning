package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/copy-list-with-random-pointer/
 * @author zhangxq
 * @since 2023/5/3
 */
public class P38CopyListWithRandomPointer {
    
    public static void main(String[] args) {
    
    }
    
    public Node copyRandomList(Node head) {
        // 1 在节点后复制一个小弟
        for (var p = head; p != null; p = p.next.next) {
            var q = new Node(p.val);
            q.next = p.next;
            p.next = q;
        }
        // 2 遍历整个链表，小弟需要指向相应的 random 指针
        for (var p = head; p != null; p = p.next.next)
            if (p.random != null)
                p.next.random = p.random.next;
        // 3 将两个链表拆出来
        var dummy = new Node(-1);
        var cur = dummy;
        for (var p = head; p != null; p = p.next) {
            var q = p.next;
            cur = cur.next = q;
            p.next = q.next;
        }
        return dummy.next;
    }
    
    class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
