package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/add-two-numbers-ii/
 * @author zhangxq
 * @since 2023/6/12
 */
public class P445AddTwoNumbersII {
    
    public static void main(String[] args) {
        var solution = new P445AddTwoNumbersII();
        var res = solution.addTwoNumbers(new ListNode(1), new ListNode(2));
        System.out.println(res.val);
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var rl1 = reverse(l1);
        var rl2 = reverse(l2);
        var res = new ListNode(-1);
        var pre = res; var carry = 0;
        while (rl1 != null || rl2 != null) {
            int a = rl1 != null ? rl1.val : 0;
            int b = rl2 != null ? rl2.val : 0;
            int c = a + b + carry;
            pre.next = new ListNode(c % 10);
            carry = c / 10;
            pre = pre.next;
            rl1 = rl1 != null ? rl1.next : null;
            rl2 = rl2 != null ? rl2.next : null;
        }
        if (carry != 0) pre.next = new ListNode(carry);
        return reverse(res.next);
    }
    public ListNode reverse(ListNode head) {
        ListNode pre = null; var cur = head;
        while (cur != null) {
            var t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }
        return pre;
    }
    
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
