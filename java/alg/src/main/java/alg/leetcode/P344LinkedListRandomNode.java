package alg.leetcode;

import java.util.Random;

/**
 * @link https://leetcode.cn/problems/linked-list-random-node/
 * @author zhangxq
 * @since 2023/6/5
 */
public class P344LinkedListRandomNode {
    
    public static void main(String[] args) {
    
    }
    
    // 蓄水池抽样算法
    static
    class Solution {
        ListNode head;
        public Solution(ListNode head) {
            this.head = head;
        }
        public int getRandom() {
            Random random = new Random();
            int c = -1, n = 0; // n 表示当前的人数
            for (var p = head; p != null; p = p.next) {
                n++;
                if (random.nextInt() % n == 0) c = p.val;
            }
            return c;
        }
    }
    
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
