package alg.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/heaters/
 * @author zhangxq
 * @since 2023/6/16
 */
public class P475Heaters {
    
    public static void main(String[] args) {
    
    }
    
    int[] houses;
    int[] heaters;
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        this.houses = houses;
        this.heaters = heaters;
        int l = 0, r = Integer.MAX_VALUE;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(mid)) r = mid;
            else l = mid + 1;
        }
        return r;
    }
    public boolean check(int mid) {
        for (int i = 0, j = 0; i < houses.length; i++) {
            while (j < heaters.length && Math.abs(heaters[j] - houses[i]) > mid)
                j++;
            if (j >= heaters.length) return false;
        }
        return true;
    }
}
