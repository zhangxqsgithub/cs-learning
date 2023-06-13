package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/circular-array-loop/
 * @author zhangxq
 * @since 2023/6/13
 */
public class P457CircularArrayLoop {
    
    public static void main(String[] args) {
        System.out.println(true ^ true);
    }
    
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length, base = 10000;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= base) continue;
            int k = i, s = base + i;
            boolean t = nums[k] > 0; // 当前符号
            int last = -1; // 表示最后一个位置
            do {
                int p = ((k + nums[k])  % n + n) % n;
                last = nums[k];
                nums[k] = s;
                k = p;
            }
            while (k != i && nums[k] < base && t == nums[k] > 0);
            if (last % n != 0 && nums[k] == s) return true;
        }
        return false;
    }
}
