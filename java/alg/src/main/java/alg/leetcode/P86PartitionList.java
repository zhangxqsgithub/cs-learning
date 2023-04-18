package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/partition-list/
 * @author zhangxq
 * @since 2023/4/17
 */
public class P86PartitionList {
    
    public static void main(String[] args) {
        ListNode head1 = new ListNode(2, new ListNode(1));
        P86PartitionList solution = new P86PartitionList();
        ListNode res1 = solution.partition(head1, 2);
        System.out.println(res1);
    }
    
    /**
     * 定义两个头结点 before,after，分别存储两个部分对应的链表。
     * 然后遍历原链表，对于每个节点，如果小于 x，则插入 before 链表的结尾；否则，插入 after 链表的结尾。
     */
    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode();
        ListNode after = new ListNode();
        ListNode pb = before, pa = after;
        for (ListNode p = head; p != null; p = p.next) {
            if (p.val < x) {
                pb.next = p;
                pb = p;
            }
            else {
                pa.next = p;
                pa = p;
            }
        }
        pb.next = after.next;
        /*
        评测程序会遍历一遍结果链表，如果不执行 pa->next = 0; 的话，链表的结尾可能指向链表中的某个节点，这样遍历结果链表的时候就死循环了。
        就这个样例而言，跳出for后pa指向初始链表中的5，如果不断开，pa->next是初始链表最后面的2，画个图就知道出事儿了。
         */
        pa.next = null;
        return before.next;
    }
    
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
