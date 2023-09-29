package alg.leetcode;

import java.util.List;

/**
 * @link https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/
 * @author zhangxq
 * @since 2023/9/29
 */
public class P559MaximumDepthOfNAryTree {
    
    public static void main(String[] args) {
    
    }
    
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int res = 0;
        for (var c : root.children) res = Math.max(res, maxDepth(c));
        return res + 1;
    }
    
    static class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val) { val = _val; }
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
