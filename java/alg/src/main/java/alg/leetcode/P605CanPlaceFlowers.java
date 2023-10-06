package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/can-place-flowers/
 * @author zhangxq
 * @since 2023/10/6
 */
public class P605CanPlaceFlowers {
    
    public static void main(String[] args) {
    
    }
    
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int res = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) continue;
            int j = i;
            while (j < flowerbed.length && flowerbed[j] == 0) j++;
            int k = j - i - 1; // 当前 0 的长度
            if (i == 0) k++;
            if (j == flowerbed.length) k++;
            res += k / 2;
            i = j;
        }
        return res >= n;
    }
}
