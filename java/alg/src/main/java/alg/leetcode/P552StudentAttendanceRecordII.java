package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/student-attendance-record-ii/
 * @author zhangxq
 * @since 2023/9/28
 */
public class P552StudentAttendanceRecordII {
    
    public static void main(String[] args) {
    
    }
    
    public int checkRecord(int n) {
        int mod = (int) 1e9 + 7;
        var dp = new int[n + 1][2][3];
        dp[0][0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j == 0) dp[i + 1][j + 1][0] = (dp[i + 1][j + 1][0] + dp[i][j][k]) % mod;
                    if (k + 1 <= 2) dp[i + 1][j][k + 1] = (dp[i + 1][j][k + 1] + dp[i][j][k]) % mod;
                    dp[i + 1][j][0] = (dp[i + 1][j][0] + dp[i][j][k]) % mod;
                }
            }
        }
        
        int res = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                res = (res + dp[n][j][k]) % mod;
            }
        }
        return res;
    }
}
