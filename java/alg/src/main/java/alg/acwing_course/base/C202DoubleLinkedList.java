package alg.acwing_course.base;

/**
 * @author will
 * @since 2024/4/9
 */
public class C202DoubleLinkedList {
    
    // 用数组存储双连标
    static class DoubleLinkedList {
        static int N = 100010;
        static int[] l = new int[N];
        static int[] r = new int[N];
        static int[] e = new int[N];
        static int idx;
        static void init() {
            r[0] = 1; // 第 0 个位置的右端点在 1
            l[1] = 0; // 第 1 个位置的做断点在 0
            idx = 2; // 此时空位置指向 2
        }
        // 在节点 i 的右边插入一个数 x
        static void add(int i, int x) {
            e[idx] = x;      // 存储值 x
            l[idx] = i;      // 该存储值的左端点是 i
            r[idx] = r[i];   // 该存储值的右端点是 i 的右端点
            l[r[i]] = idx;   // 节点 i 的有端点（原来的有端点）的左端点值为 idx
            r[i] = idx;      // 节点 i 的有端点是 idx
            idx++;           // 指向下一个数组中的空位置
        }
        // 删除节点 i
        static void delete(int i) {
            l[r[i]] = l[i]; // i 的右端点的左端点值为 i 的左端点
            r[l[i]] = r[i]; // i 的左端点的右端点值为 i 的右端点
        }
    }
}
