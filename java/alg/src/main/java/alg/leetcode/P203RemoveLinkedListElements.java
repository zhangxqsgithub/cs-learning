package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/remove-linked-list-elements/
 * @author zhangxq
 * @since 2023/5/8
 */
public class P203RemoveLinkedListElements {
    
    public static void main(String[] args) {
    
    }
    
    public ListNode removeElements(ListNode head, int val) {
        var dummy = new ListNode(-1, head);
        var pre = dummy;
        while (pre.next != null) {
            if (pre.next.val == val) pre.next = pre.next.next;
            else pre = pre.next;
        }
        return dummy.next;
    }
    
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
