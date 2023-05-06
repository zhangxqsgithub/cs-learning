package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/insertion-sort-list/
 * @author zhangxq
 * @since 2023/5/6
 */
public class P147InsertionSortList {
    
    public static void main(String[] args) {
    
    }
    
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        var dummy = new ListNode(-10000);
        dummy.next = head;
        var lastSorted = head;
        var cur = head.next;
        while (cur != null) {
            if (lastSorted.val <= cur.val)
                lastSorted = lastSorted.next;
            else {
                var pre = dummy;
                while (pre.next.val <= cur.val) {
                    pre = pre.next;
                }
                lastSorted.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = lastSorted.next;
        }
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
