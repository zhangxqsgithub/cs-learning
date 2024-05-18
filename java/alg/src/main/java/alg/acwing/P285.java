package alg.acwing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 没有上司的舞会
 *
 * @link https://www.acwing.com/problem/content/287/
 * @author will
 * @since 2024/5/18
 */
public class P285 {
    
    static int[] happy, head, edge, nedge;
    static int[][] dp;
    static int idx = 0;
    /**
     * 1. dp 子问题：
     * 2. dp 数组定义：
     *    dp[u][0] 表示所有从 u 为根的子树中选择，并且不选择 u 这个点的方案。
     *    dp[u][1] 表示所有从 u 为根的子树中选择，并且选择 u 这个点的方案。
     *    值为快乐指数总和的最大值。
     * 3. dp 方程：
     *    dp[u][0] = ∑max(dp[s_i][0], dp[s_i][1]), i=[0,n)，n表示子节点数量
     *    dp[u][1] = ∑dp[s_i][0]
     * 4. 初始化：
     * 5. 结果：
     */
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        happy = new int[n + 1];
        head = new int[n + 1];
        edge = new int[n + 1];
        nedge = new int[n + 1];
        dp = new int[n + 1][2];
        Arrays.fill(head, -1);
        for (int i = 1; i <= n; i++) happy[i] = sc.nextInt();
        // 记录点是否有父节点
        var hasFather = new boolean[n + 1];
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            link(b, a);
            hasFather[a] = true;
        }
        // 找到根节点
        int root = 1;
        while (hasFather[root]) root++;
        dfs(root);
        var res = Math.max(dp[root][0], dp[root][1]);
        System.out.println(res);
    }
    
    private static void dfs(int u) {
        dp[u][1] = happy[u];
        for (int i = head[u]; i != -1; i = nedge[i]) {
            int j = edge[i];
            dfs(j);
            dp[u][0] += Math.max(dp[j][0], dp[j][1]);
            dp[u][1] += dp[j][0];
        }
    }
    
    private static void link(int father, int son) {
        edge[idx] = son; nedge[idx] = head[father]; head[father] = idx++;
    }
}
