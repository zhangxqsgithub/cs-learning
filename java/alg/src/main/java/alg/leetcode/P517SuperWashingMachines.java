package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/super-washing-machines/
 * @author zhangxq
 * @since 2023/9/22
 */
public class P517SuperWashingMachines {
    
    public static void main(String[] args) {
    
    }
    
    public int findMinMoves(int[] machines) {
        int n = machines.length, sum = 0;
        for (var x : machines) sum += x;
        if (sum % n > 0) return -1;
        int avg = sum / n, left = 0, right = sum;
        int res = 0;
        for (int i = 0; i < n; i++) {
            right -= machines[i];
            if (i != 0) left += machines[i - 1];
            int l = Math.max(avg * i - left, 0);
            int r = Math.max(avg * (n - i - 1) - right, 0);
            res = Math.max(res, l + r);
        }
        return res;
    }
}
