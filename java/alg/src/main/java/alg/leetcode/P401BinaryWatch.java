package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/binary-watch/
 * @author zhangxq
 * @since 2023/6/8
 */
public class P401BinaryWatch {
    
    public static void main(String[] args) {
    
    }
    
    // 枚举二进制表示的所有情况，如果当前二进制表示恰好有 n 个 1 并且是一个合法时间的话就是一个结果。
    public List<String> readBinaryWatch(int n) {
        var res = new ArrayList<String>();
        for (int i = 0; i < 1 << 10; i++) {
            int s = 0;
            for (int j = 0; j < 10; j++) if ((i >> j & 1) == 1) s++;
            // 恰好有 n 个 1
            if (s == n) {
                int hour = i >> 6; int minutes = i & 63;
                if (hour < 12 && minutes < 60) {
                    if(minutes<10) res.add(hour+":0"+minutes);
                    else res.add(hour+":"+minutes);
                }
            }
        }
        return res;
    }
}
