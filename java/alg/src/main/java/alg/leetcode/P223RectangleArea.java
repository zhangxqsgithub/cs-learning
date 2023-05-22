package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/rectangle-area/
 * @author zhangxq
 * @since 2023/5/22
 */
public class P223RectangleArea {
    
    public static void main(String[] args) {
    
    }
    
    public int computeArea(long ax1, long ay1, long ax2, long ay2, long bx1, long by1, long bx2, long by2) {
        long x = Math.max(0L, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        long y = Math.max(0L, Math.min(ay2, by2) - Math.max(ay1, by1));
        return (int) ((ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - x * y);
    }
    
}
