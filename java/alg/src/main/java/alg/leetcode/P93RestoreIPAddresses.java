package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原 IP 地址
 *
 * @link https://leetcode.cn/problems/restore-ip-addresses/
 * @author zhangxq
 * @since 2023/4/19
 */
public class P93RestoreIPAddresses {
    
    public static void main(String[] args) {
    
    }
    
    List<String> ans = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0, "");
        return ans;
    }
    
    // u表示枚举到的字符串下标，k表示当前截断的IP个数，s表示原字符串
    public void dfs(String s, int u, int k, String path) {
        if (u == s.length()) {
            if (k == 4) ans.add(path.substring(0, path.length() - 1));
            return;
        }
        // 当前阶段的 IP 个数 >= 4 个并且处理还没有结束，则返回
        if (k >= 4) return;
        for (int i = u, t = 0; i < s.length(); i++) {
            // 如果有前导 0
            if (i > u && s.charAt(u) == '0') break;
            t = t * 10 + s.charAt(i) - '0';
            if (t > 255) break;
            dfs(s, i + 1, k + 1, path + t + ".");
        }
    }

}
