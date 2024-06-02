package alg.acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 拦截导弹
 * @link https://www.acwing.com/problem/content/1012/
 * @author will
 * @since 2024/6/2
 */
public class P1010 {
    
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var s = br.readLine().split(" ");
        var arr = new int[s.length];
        for (int i = 0; i < s.length; i++) arr[i] = Integer.parseInt(s[i]);
        var lds = lds(arr);
        System.out.println(lds);
        
        /**
         * 贪心
         * 从前到后扫描没个数，将每个可以拦截的队列保存下来，最后一位数是最后拦截导弹的高度。
         * 处理当前数的多个情况：
         * 情况 1：如果现有子序列的结尾都小于当前数，则创建新子序列
         * 情况 2：如果现有子序列的结尾部分大于当前数，则将追加到 > 当前数的结尾中最小的数那个队列
         * 情况 3：如果现有子序列的结尾都大于当前数，则和情况 2 一致
         * 实际上和最长上升子序列的长度问题一样。
         *
         * Dilworth 定理
         */
        var lis = lis(arr);
        System.out.println(lis);
    }
    
    // 最长下降子序列的长度
    public static int lds(int[] arr) {
        int n = arr.length;
        var dp = new int[n];
        var res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] <= arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    
    public static int lis(int[] arr) {
        int n = arr.length;
        var dp = new int[n];
        var res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    
    public static int q(int[] arr) {
        int n = arr.length;
        var g = new int[n];
        // 表示可以覆盖全部输入的下降子序列的数量
        int cnt = 0;
        for (int num : arr) {
            // 表示从前往后枚举所有子序列,因为子序列的结尾的数是单调上升的，
            // 所以只要枚举到比自己大的第一个数就可以直接替换掉这个比自己大的数
            int k = 0;
            while (k < cnt && g[k] < num) k++;
            // 如果第一个大于当前数的就是第k个，所以直接将第k个序列的结尾替换成当前数就行
            g[k] = num;
            // 如果枚举超过了我们的全部序列，就说明没有一个数是比我们大的，就需要新开组别
            if (k >= cnt) cnt++;
        }
        return cnt;
    }
}
