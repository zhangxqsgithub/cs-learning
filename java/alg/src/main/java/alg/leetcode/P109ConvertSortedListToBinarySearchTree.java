package alg.leetcode;

import java.awt.image.renderable.RenderableImage;
import java.util.ArrayList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/
 * @author zhangxq
 * @since 2023/4/26
 */
public class P109ConvertSortedListToBinarySearchTree {
    
    public static void main(String[] args) {
    
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return build(head,null);
    }
    private TreeNode build(ListNode start,ListNode end){
        if(start == end) return null;
        ListNode slow = start;
        ListNode fast = start;
        while(fast != end && fast.next != end){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = build(start,slow);
        root.right = build(slow.next,end);
        return root;
    }
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
