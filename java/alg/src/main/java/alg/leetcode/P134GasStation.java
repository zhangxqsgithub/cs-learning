package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/gas-station/
 * @author zhangxq
 * @since 2023/4/27
 */
public class P134GasStation {
    
    public static void main(String[] args) {
    
    }
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        var n = gas.length;
        for (var i = 0; i < n;) {
            var left = 0; // 剩余油量
            int j;
            for (j = 0; j < n; j++) {
                var k = (i + j) % n;
                left += gas[k] - cost[k];
                if (left < 0) break;
            }
            if (j == n) return i; // 合法
            i = i + j + 1;
        }
        return -1;
    }
    
}
