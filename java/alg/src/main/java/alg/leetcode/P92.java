package alg.leetcode;

/**
 * @author zhangxq
 * @since 2023/4/19
 */
public class P92 {
    
    public static void main(String[] args) {
    
    }
    
    // 要求是只能扫描一遍
    public ListNode reverseBetween(ListNode head, int left, int right) {
        var dummy = new ListNode(-1);
        dummy.next = head;
        // 往前走 left 步
        var a = dummy;
        for (int i = 0; i < left - 1; i++) a = a.next;
        // 反转链表
        var b = a.next; var c = b.next;
        for (int i = 0; i < right - left; i++) {
            var t = c.next;
            c.next = b; b = c; c = t;
        }
        a.next.next = c;
        a.next = b;
        return dummy.next;
    }
    
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
