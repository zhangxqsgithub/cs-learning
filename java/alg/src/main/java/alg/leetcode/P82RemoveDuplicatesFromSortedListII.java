package alg.leetcode;

import java.security.DrbgParameters;

/**
 * @link https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 * @author zhangxq
 * @since 2023/4/17
 */
public class P82RemoveDuplicatesFromSortedListII {
    
    public static void main(String[] args) {
    
    }
    
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
            ListNode q = p.next;
            while (q != null && q.val == p.next.val) q = q.next;
            // 往下走一步
            if (p.next.next == q) p = p.next;
            // 若不相等说明有重复元素
            else p.next = q;
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
