package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/reorder-list/
 * @author zhangxq
 * @since 2023/5/3
 */
public class P143ReorderList {
    
    public static void main(String[] args) {
    
    }
    
    public void reorderList(ListNode head) {
        if (head == null) return;
        var n = 0;
        for (var p = head; p != null; p = p.next) n++;
        
        var mid = head;
        for (var i = 0; i < (n + 1) / 2 - 1; i++) mid = mid.next;
        var a = mid; var b = a.next;
        for (var i = 0; i < n / 2; i++) {
            var c = b.next;
            b.next = a; a = b; b = c;
        }
        
        var p = head; var q = a;
        for (var i = 0; i < n / 2; i++) {
            var o = q.next;
            q.next = p.next;
            p.next = q;
            if (n % 2 == 0 && i == n / 2 - 1) q.next = null;
            p = q.next;
            q = o;
        }
        if (n % 2 == 1) p.next = null;
    }
    
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
