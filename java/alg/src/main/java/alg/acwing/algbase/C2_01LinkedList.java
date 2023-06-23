package alg.acwing.algbase;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表与邻接表：树与图的存储
 *
 * @author zhangxq
 * @since 2023/6/23
 */
public class C2_01LinkedList {
    
    public static void main(String[] args) {
    
    }
    
    // 使用数组存储元素的单链表
    static class SingleLinkedList {
        int head; // 存储链表头
        List<Integer> elements; // 存储节点值
        List<Integer> next; // 存储节点的 next 指针
        int idx; // 表示当前用到了哪个节点
        public SingleLinkedList() {
            head = -1;
            elements = new ArrayList<>();
            next = new ArrayList<>();
            idx = -1;
        }
        public void insert(int num) {
            elements.add(num);
            next.add(head);
            idx++;
            head = idx;
        }
        public void removeFirst() {
            head = next.get(head);
        }
    }

}
