package alg.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @link https://leetcode.cn/problems/all-oone-data-structure/
 * @author zhangxq
 * @since 2023/6/10
 */
public class P432AllOoneDataStructure {
    
    public static void main(String[] args) {
        var solution = new AllOne();
        solution.inc("a");
        solution.inc("a");
        solution.inc("b");
        System.out.println(solution.getMinKey());
        System.out.println(solution.getMaxKey());
        System.out.println(solution.getMinKey());
        System.out.println(solution.getMaxKey());
    }
    
    static
    class AllOne {
        Map<String, Node> map;
        // 左右边界
        Node left;
        Node right;
        public AllOne() {
            map = new HashMap<>();
            left = Node.of(Integer.MIN_VALUE, null, null);
            right = Node.of(Integer.MAX_VALUE, null, null);
            left.right = right; right.left = left;
        }
        public void inc(String key) {
            if (!map.containsKey(key)) {
                map.put(key, addToRight(left, key, 1));
            }
            else {
                var node = map.get(key);
                node.set.remove(key);
                map.put(key, addToRight(node, key, node.val + 1));
                if (node.set.isEmpty()) remove(node);
            }
        }
        public void dec(String key) {
            if (!map.containsKey(key)) return;
            var node = map.get(key);
            node.set.remove(key);
            if (node.val > 1) map.put(key, addToLeft(node, key, node.val - 1));
            else map.remove(key);
            if (node.set.isEmpty()) remove(node);
        }
        public String getMaxKey() {
            if (right.left == left) return "";
            else return right.left.set.iterator().next();
        }
        public String getMinKey() {
            if (left.right == right) return "";
            else return left.right.set.iterator().next();
        }
        public Node addToLeft(Node node, String key, int val) {
            if (node.left.val != val) {
                var t = Node.of(val, node.left, node);
                t.set.add(key);
                node.left.right = t;
                node.left = t;
            }
            else node.left.set.add(key);
            return node.left;
        }
        public Node addToRight(Node node, String key, int val) {
            if (node.right.val != val) {
                var t = Node.of(val, node, node.right);
                t.set.add(key);
                node.right.left = t;
                node.right = t;
            }
            else node.right.set.add(key);
            return node.right;
        }
        public void remove(Node node) {
            node.left.right = node.right;
            node.right.left = node.left;
        }
    }
    static class Node {
        int val;
        Node left;
        Node right;
        Set<String> set;
        public static Node of(int val, Node left, Node right) {
            var res = new Node();
            res.val = val;
            res.left = left;
            res.right = right;
            res.set = new HashSet<>();
            return res;
        }
    }
}
