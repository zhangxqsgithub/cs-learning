package alg.acwing;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @link https://www.acwing.com/problem/content/description/150/
 * @author will
 * @since 2024/5/21
 */
public class P148 {
    
    /**
     * Huffman 树
     * 解法：
     * 1. 任何一种合并方式都可以转化成一颗完全二叉树的合并
     * 2. 转化之后的代价就是所有叶节点的权值 * 到根节点的距离的总和
     * 3. 本质是 Huffman 树问题：每次选择权值最小的两个数合并即可得到答案。
     * 证明：
     * 1. 一定存在一组最优解，使得权值最小的两个点可以位于完全二叉树的最下面一层，
     *    且互为兄弟节点。
     * 2. n 个点的 Huffman 树问题，在合并最小的两个点之后，可以转化成 n - 1
     *    个点的 Huffman 树问题。
     *    n - 1 个点的最优解 => n 个点的最优解
     */
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var n = sc.nextInt();
        // 小根堆
        var minHeap = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++) minHeap.add(sc.nextInt());
        int res = 0;
        while (minHeap.size() > 1) {
            int x = minHeap.poll(), y = minHeap.poll(), z = x + y;
            res += z;
            minHeap.add(z);
        }
        System.out.println(res);
    }
}
