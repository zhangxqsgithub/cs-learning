package alg.leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 合并 K 个升序链表
 *
 * @author zhangxq
 * @link https://leetcode.cn/problems/merge-k-sorted-lists/
 * @since 2022/12/12
 */
public class P23MergeKSortedLists {
    
    /**
     * 和 合并两个链表的思路一致，即一直合并所有链表头节点最小的那个元素
     * 时间复杂度为 nk n为每个列表的元素数量，k个链表
     * （可以使用小顶堆加速到 nlogk（小顶堆取数是 logn 的））
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // 先将所有的头节点加入到小顶堆中
        var heap = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        for (var list : lists) {
            if (list != null) heap.offer(list);
        }
    
        // 虚拟头节点
        var dummy = new ListNode(-1);
        var tail = dummy;
        
        while (!heap.isEmpty()) {
            var t = heap.poll();
            tail = tail.next = t;
            if (t.next != null) heap.offer(t.next);
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
