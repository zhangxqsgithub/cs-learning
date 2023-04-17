package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 * @author zhangxq
 * @since 2023/4/17
 */
public class P83RemoveDuplicatesFromSortedList {
    
    public static void main(String[] args) {
    
    }
    
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        while (p.next != null) {
            if (p.val == p.next.val) p.next = p.next.next;
            else p = p.next;
        }
        return head;
    }
    
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
