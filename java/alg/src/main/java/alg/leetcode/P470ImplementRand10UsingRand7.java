package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/implement-rand10-using-rand7/
 * @author zhangxq
 * @since 2023/6/15
 */
public class P470ImplementRand10UsingRand7 {
    
    public static void main(String[] args) {
    
    }
    
    public int rand10() {
        int t = (rand7() - 1) * 7 + rand7(); // 生成一个 1～49 的随机数
        if (t > 40) return rand10();
        // t 是一个 1～40 的随机数
        return (t - 1) % 10 + 1;
    }
    
    public int rand7() {
        return 0;
    }
}
