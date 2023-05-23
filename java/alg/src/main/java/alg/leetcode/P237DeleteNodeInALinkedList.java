package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/delete-node-in-a-linked-list/
 * @author zhangxq
 * @since 2023/5/23
 */
public class P237DeleteNodeInALinkedList {
    
    public static void main(String[] args) {
    
    }
    
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
