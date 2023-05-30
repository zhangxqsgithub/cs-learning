package alg.leetcode;

import java.util.*;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/reconstruct-itinerary/
 * @since 2023/5/30
 */
public class P332ReconstructItinerary {
    
    public static void main(String[] args) {
        P332ReconstructItinerary solution = new P332ReconstructItinerary();
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK","MUC"));
        tickets.add(Arrays.asList("SFO","SJC"));
        tickets.add(Arrays.asList("LHR","SFO"));
        List<String> res = solution.findItinerary(tickets);
        System.out.println(res);
    }
    
    // 欧拉路径算法
    Map<String, Queue<String>> g = new HashMap<>();
    LinkedList<String> res = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (var e : tickets) {
            var v = g.get(e.get(0));
            if (v == null) {
                g.put(e.get(0), new PriorityQueue<>());
                v = g.get(e.get(0));
            }
            v.add(e.get(1));
        }
        dfs("JFK");
        return res;
    }
    public void dfs(String u) {
        while (g.get(u) != null && !g.get(u).isEmpty()) { // 每次选择一个没有走过的边走
            var ver = g.get(u).poll();
            dfs(ver);
        }
        res.addFirst(u); // 回溯序列就是欧拉路径
    }
}
