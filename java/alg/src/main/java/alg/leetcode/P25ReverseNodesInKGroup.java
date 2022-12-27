package alg.leetcode;

/**
 * K 个一组翻转链表
 *
 * @author zhangxq
 * @link https://leetcode.cn/problems/reverse-nodes-in-k-group/
 * @since 2022/12/26
 */
public class P25ReverseNodesInKGroup {
    
    public ListNode reverseKGroup(ListNode head, int k) {
        // 1. 判断是否足够 k 个元素
        // 2. 内部顺序调换   0 -> 1 -> 2 -> 3 -> 4  =>  0 -> 1 <- 2 <- 3 -> 4
        //    首指针指      0  1 <- 2 <- 3 -> 4
        //                ｜           ↑
        //                 ————————————
        //    尾部指针      0  1 <- 2 <- 3   4
        //                   ｜             ↑
        //                    ——————————————
        
        // 虚拟头节点
        var dummy = new ListNode(-1);
        dummy.next = head;
        
        var pre = dummy;
        while (pre.next != null) {
            // 往后跳 k 步
            var q = pre;
            for (int i = 0; i < k && q != null; i++) q = q.next;
            if (q == null) break;
            
            // a 为头节点
            ListNode a = pre.next, b = a.next;
            for (var i = 1; i < k; i++) {
                var c = b.next;
                b.next = a;
                a = b;
                b = c;
            }
        
            var c = pre.next;
            pre.next = a;
            c.next = b;
    
            pre = c;
        }
        
        return dummy.next;
    }
    
    public class ListNode {
        int val;
        ListNode next;
        
        ListNode() {
        }
        
        ListNode(int val) {
            this.val = val;
        }
        
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
}
