package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/sort-list/
 * @author zhangxq
 * @since 2023/5/6
 */
public class P148SortList {
    
    public static void main(String[] args) {
    }
    
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        
        var n = 0;
        for (var p = head; p != null; p = p.next) n++;
        
        for (var i = 1; i < n; i *= 2) {
            var dummy = new ListNode(Integer.MIN_VALUE);
            var cur = dummy;
            for (var j = 1; j <= n; j += i * 2) {
                var p = head; var q = p;
                for (var k = 0; k < i && q != null; k++) q = q.next;
                var o = q;
                for (var k = 0; k < i && o != null; k++) o = o.next;
                // 开始归并两个链表
                var l = 0; var r = 0;
                while (l < i && r < i && p != null && q != null) {
                    if (p.val <= q.val) {
                        cur = cur.next = p;
                        p = p.next;
                        l++;
                    }
                    else {
                        cur = cur.next = q;
                        q = q.next;
                        r++;
                    }
                }
                while (l < i && p != null) { cur = cur.next = p; p = p.next; l++; }
                while (r < i && q != null) { cur = cur.next = q; q = q.next; r++; }
                // 头节点等于下一段的开头
                head = o;
            }
            cur.next = null;
            head = dummy.next;
        }
        
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
