package alg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @link https://leetcode.cn/problems/clone-graph/
 * @author zhangxq
 * @since 2023/4/27
 */
public class P133CloneGraph {
    
    public static void main(String[] args) {
    
    }
    
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        dfs(node);
        map.forEach((s, d) -> {
            for (Node ver : s.neighbors)
                d.neighbors.add(map.get(ver));
        });
        return map.get(node);
    }
    
    private void dfs(Node node) {
        map.put(node, new Node(node.val));
        for (var ver : node.neighbors)
            if (!map.containsKey(ver))
                dfs(ver);
    }
    
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
