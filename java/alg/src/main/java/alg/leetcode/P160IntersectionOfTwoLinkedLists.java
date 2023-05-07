package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/intersection-of-two-linked-lists/
 * @author zhangxq
 * @since 2023/5/7
 */
public class P160IntersectionOfTwoLinkedLists {
    
    public static void main(String[] args) {
    
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        var a = headA; var b = headB;
        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return a;
    }
    
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
}
