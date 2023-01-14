package alg.leetcode;

/**
 * 旋转链表
 *
 * @author zhangxq
 * @link https://leetcode.cn/problems/rotate-list/
 * @since 2023/1/11
 */
public class P61RotateList {
    
    public static void main(String[] args) {
    
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int n = 0;
        ListNode tail = null; // 尾节点
        // 链表有 n 个节点
        for (ListNode p = head; p != null; p = p.next) {
            tail = p;
            n++;
        }
        // 求 k % n
        k = k % n;
        if (k == 0) return head;
        ListNode p = head;
        for (int i = 0; i < n - k - 1; i ++) p = p.next;
        tail.next = head;
        head = p.next;
        p.next = null;
        return head;
    }
    
    static class ListNode {
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
