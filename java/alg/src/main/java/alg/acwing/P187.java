package alg.acwing;

import java.util.Scanner;

/**
 * 导弹防御系统
 *
 * @link https://www.acwing.com/problem/content/189/
 * @author will
 * @since 2024/6/2
 */
public class P187 {
    
    static int N = 60;
    static int n;
    // 记录单调上升数组元素个数和单调下降数组元素个数
    static int[] h, up, down;
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        while (true) {
            up = new int[N]; down = new int[N];
            n = sc.nextInt();
            if (n == 0) break;
            h = new int[n];
            for (int i = 0; i < n; i++) h[i] = sc.nextInt();
            int depth = 0;
            while (!dfs(depth, 0, 0, 0)) depth++;
            System.out.println(depth);
        }
    }
    
    /**
     * 给出一个序列，将其拆分成多个子序列，这些子序列满足要么单调上升要么单调下降。
     * 所有拆分方案中，子序列数量最少的拆分方案，给出子序列的数量。
     *
     * 依次枚举每个数，将该数放到单调上升的序列里还是放到单调下降的序列里。
     * 1. 放到单调上升的序列中，枚举放到哪个单调上升的序列中（贪心，放到小于该数最大的那个元素的末尾）
     * 2. 放到单调下降的序列中，枚举放到哪个单调下降的序列中（放到大于该数最小的那个元素的末尾）
     *
     */
    public static boolean dfs(int depth, int u, int su, int sd) {
        if (su + sd > depth) return false;
        // 如果 n 个数都分配完了那就是一个合法解
        if (u == n) return true;
        
        // 枚举放到上升子序列中的情况
        var flag = false; // 表示有没有归到某一个上升子序列里
        for (int i = 1; i <= su; i++) {
            if (up[i] < h[u]) {
                int t = up[i];
                up[i] = h[u];
                if (dfs(depth, u + 1, su, sd)) return true;
                up[i] = t;
                flag = true;
                break;
            }
        }
        // 如果任何一个序列都没有放进去的话，就新增一个单调上升的子序列
        if (!flag) {
            up[su + 1] = h[u];
            if (dfs(depth, u + 1, su + 1, sd)) return true;
        }
        
        // 枚举放到下降子序列中的情况
        flag = false; // 表示有没有归到某一个下降子序列里
        for (int i = 1; i <= sd; i++) {
            if (down[i] > h[u]) {
                int t = down[i];
                down[i] = h[u];
                if (dfs(depth, u + 1, su, sd)) return true;
                down[i] = t;
                flag = true;
                break;
            }
        }
        if (!flag) {
            down[sd + 1] = h[u];
            if (dfs(depth, u + 1, su, sd + 1)) return true;
        }
        
        return false;
    }
}
