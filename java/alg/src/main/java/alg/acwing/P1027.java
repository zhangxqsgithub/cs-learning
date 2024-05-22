package alg.acwing;

import java.util.Scanner;

/**
 * 方格取数
 *
 * @link https://www.acwing.com/problem/content/1029/
 * @author will
 * @since 2024/5/21
 */
public class P1027 {
    
    static int N = 15;
    static int[][] w;
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var n = sc.nextInt();
        w = new int[n + 1][n + 1];
        while(true) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            if (a == 0 && b == 0 && c == 0) break;
            w[a][b] = c;
        }
        var res = take(n);
        System.out.println(res);
    }
    
    /**
     * 题意：走两遍路线，求最大和
     * 可以看作两个人一起从头走到尾，求最大和
     * 走过的路的数可以被取走，为求最大值，视作必须取走
     *
     * 我们将i1，j1，i2，j2四维状态存储dp数组。
     * 利用之前的观察，我们只需要记录步数k与i坐标，就可以推出j坐标
     * so 可以把dp数组降维为k,i1,i2的三维状态
     *
     * 怎么处理数被取走不重复取？ dp如果去改变原地图，会很复杂
     * 观察发现：
     * 因为只能走右 or 走下， 则甲和乙到达ij时，因为一起走步数必然相同
     * so，判断路线交叉，只需要在dp时，判断甲和乙的i坐标是否重叠
     * 因为i如果重叠，j一定重叠
     * 反之亦然，如果i不重叠，j一定不重叠。一定不重叠
     */
    public static int take(int n) {
        var dp = new int[N * 2][N][N];
        for(int k = 2; k <= 2*n; k++) { // k表示步数
            for(int i1 = 1; i1 <= n; i1++) {
                for(int i2 = 1; i2 <= n; i2++) {
                    int j1 = k-i1, j2 = k-i2;
                    if (1<=j1&&j1<=n&&1<=j2&&j2<=n) {
                        int t = w[i1][j1];
                        // 不重合
                        if(i1!=i2) t += w[i2][j2];
                        // 保留最大属性
                        dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k-1][i1-1][i2-1]+t);
                        dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k-1][i1-1][i2]+t);
                        dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k-1][i1][i2-1]+t);
                        dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k-1][i1][i2]+t);
                    }
                }
            }
        }
        return dp[n*2][n][n];
    }
}
