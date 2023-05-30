package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/odd-even-linked-list/
 * @author zhangxq
 * @since 2023/5/30
 */
public class P328OddEvenLinkedList {
    
    public static void main(String[] args) {
    
    }
    
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode j = head; // 基数
        ListNode p = head.next;
        ListNode o = p; // 偶数
        
        while(j.next!=null && o.next!=null){
            j.next = o.next;
            j = j.next;
            o.next = j.next;
            o = o.next;
        }
        j.next = p;
        return head;
    }
    
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
