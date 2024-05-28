package alg.acwing;

import java.util.Scanner;

/**
 * 蒙德里安的梦想
 *
 * 状态压缩 DP
 * 状态压缩动态规划是一种优化动态规划的方法，特别适用于某些特定类型的问题，这些问题的状
 * 态可以用一个位掩码（bitmask）来表示。状态压缩通过利用位运算将多个状态信息压缩到一个
 * 整数中，从而减少了状态空间的大小，提高了算法的效率。
 *
 * @link https://www.acwing.com/problem/content/293/
 * @author will
 * @since 2024/5/17
 */
public class P291 {
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt(), m = sc.nextInt();
            if (n == 0 && m == 0) break;
            var res = dream(n, m);
            System.out.println(res);
        }
    }
    
    /*
    1. dp 子问题：
       核心思想：想放横着的两个小方块，再放竖着的两个小方块，当放满横着的小方块后，就可以
       不用统计竖着的小方块了。
       总方案数是只统计横着的两个小方块，合法的放置方法有多少种。
       如何判断当前方案是合法的？当我们将横着的小方块放进去之后，判断剩下的空间是否能被竖
       着的小方块填满，若能此方案就是合法的。
       若每一列内部所有连续的空着的小方块的个数是偶数个，则这一列是竖着放小方块就是合法的。
    2. dp 数组定义：dp[i][j] 表示已经将第 i - 1 列摆好，并且从第 i - 1 列的小方块延
       伸到第 i 列，行的状态是 j 的所有方案数。j 的状态可以表示为 0000 ～ 1111，0 表
       示未伸出到第 i 列，1 表示伸出到第 i 列，第 1 个数表示第 1 行依次类推到 n 行。
       要想求 dp[i][j] 就要知道对于 dp[i][j] 而言，dp[i - 1][k] 即第 i - 1 列伸到
       第 i 列状态数为 k 的所有方案中是否与 dp[i][j] 有冲突，即若第 i - 1 列某一行的
       小方块即被状态数 k 占据又被状态数 j 占据，这种有冲突的方案是不合法的，即满足条件
       j & k == 0。此时横着放的两个小方块是正确的，还需要判断竖着放的小方块是否合法，即
       所有列所有连续空着的小方块个数是偶数个。
       dp[i][j] 的方案数是满足条件的所有 dp[i - 1][k] 方案数之和。
    3. dp 方程：dp[i][j] = sum(dp[i - 1][k]), k=[0, 2^n - 1]，并且 k 要满足条件
    4. 初始化：dp[0][0] = 1，假设空棋盘的时候有 1 中方案
    5. 结果：dp[m][0] 表示前 m - 1 列已经摆好，并且伸到第 m 列的状态数是 0，也就是没
       伸到 m + 1 列。
    
    时间复杂度： m * 2^n * 2^n
     */
    public static long dream(int n, int m) {
        int _n = m + 1, _m = 1 << n;
        // 记录 _m 个数中是否有偶数个连续的 0
        var st = new boolean[_m];
        for (int i = 0; i < _m; i++) {
            var valid = true;
            int cnt = 0; // 记录 0 出现的次数
            for (int j = 0; j < n; j++) { // 用 n 为二进制数
                if ((i >> j & 1) != 0) {
                    if ((cnt & 1) != 0) { // 判断 cnt 是否是偶数
                        valid = false;
                        break;
                    }
                    cnt = 0;
                }
                else cnt++;
            }
            if ((cnt & 1) != 0) valid = false;
            st[i] = valid;
        }
        
        var dp = new long[_n][_m];
        dp[0][0] = 1;
        for (int i = 1; i < _n; i++) {
            for (int j = 0; j < _m; j++) {
                for (int k = 0; k < _m; k++) {
                    if ((j & k) == 0 && st[j | k]) {
                        dp[i][j] += dp[i - 1][k];
                    }
                }
            }
        }
        return dp[m][0];
    }
}
