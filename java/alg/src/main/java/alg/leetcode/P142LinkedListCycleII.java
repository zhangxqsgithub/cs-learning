package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/linked-list-cycle-ii/
 * @author zhangxq
 * @since 2023/5/3
 */
public class P142LinkedListCycleII {
    
    public static void main(String[] args) {
    
    }
    
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        var s = head; var f = head.next;
        while (f != null) {
            s = s.next; f = f.next;
            if (f == null) return null; // 没有环
            f = f.next;
            if (s == f) {
                s = head; f = f.next;
                while (s != f) { s = s.next; f = f.next; }
                return s;
            }
        }
        return null;
    }
    
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; next = null; }
    }
}
