package alg.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @link https://leetcode.cn/problems/zuma-game/
 * @author zhangxq
 * @since 2023/9/12
 */
public class P488ZumaGame {
    
    public static void main(String[] args) {
    }
    
    Map<Character, Integer> cnt = new HashMap<>();
    // 存储消除成某种状态的时候，最少需要几步。方便剪枝
    // 假定两个不同路径到达同一种状态的时候，仅保留步骤最小的那个
    Map<String, Integer> f = new HashMap<>();
    int ans = 6;
    public int findMinStep(String board, String hand) {
        // 将手里的求保存在 cnt 里
        for (var c : hand.toCharArray()) cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        f.put(board + " " + get(), 0);
        dfs(board, get());
        return ans == 6 ? -1 : ans;
    }
    private void dfs(String board, String hand) {
        if (f.get(board + " " + hand) + h(board) >= ans) return;
        for (var e : cnt.entrySet()) {
            var x = e.getKey();
            var c = e.getValue();
            if (c > 0) {
                cnt.put(x, cnt.get(x) - 1);
                for (int i = 0; i <= board.length(); i++) {
                    // 消除后的字符串
                    var r = cleanUp(board.substring(0, i) + x + board.substring(i));
                    var s = r + " " + get();
                    if (!f.containsKey(s) || f.get(s) > f.get(board + " " + hand) + 1) {
                        f.put(s, f.get(board + " " + hand) + 1);
                        if (r.isEmpty()) ans = Math.min(ans, f.get(s));
                        dfs(r, get());
                    }
                }
                cnt.put(x, cnt.get(x) + 1);
            }
        }
    }
    // 消除
    private String cleanUp(String s) {
        boolean isChanged = true;
        while (isChanged) {
            isChanged = false;
            for (int i = 0; i < s.length(); i++) {
                int j = i + 1;
                while (j < s.length() && s.charAt(j) == s.charAt(i)) j++;
                if (j - i >= 3) {
                    s = s.substring(0, i) + s.substring(j);
                    isChanged = true;
                    break;
                }
            }
        }
        return s;
    }
    private String get() {
        return cnt
                .values()
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }
    // 启发式搜索，至少还需要多少次操作
    private int h(String board) {
        var arr = board.toCharArray();
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < arr.length;) {
            int j = i + 1;
            while (j < arr.length && arr[j] == arr[i]) j++;
            if (j - i + cnt.getOrDefault(arr[i], 0) < 3) return 6;
            if (j - i < 3) res += 3 - (j - i);
            i = j;
        }
        return res;
    }
}
