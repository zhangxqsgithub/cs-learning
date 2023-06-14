package alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @link https://leetcode.cn/problems/lfu-cache/
 * @author zhangxq
 * @since 2023/6/14
 */
public class P460LfuCache {
    
    public static void main(String[] args) {
    
    }
    
    static class LFUCache {
        int capacity;
        Block head;
        Block tail;
        Map<Integer, Block> blockMap;
        Map<Integer, Node> nodeMap;
        public LFUCache(int capacity) {
            this.capacity = capacity;
            head = new Block(0); tail = new Block(Integer.MAX_VALUE);
            head.right = tail; tail.left = head;
            blockMap = new HashMap<>();
            nodeMap = new HashMap<>();
        }
        public int get(int key) {
            if (!blockMap.containsKey(key)) return -1;
            var block = blockMap.get(key);
            var node = nodeMap.get(key);
            block.remove(node);
            if (block.right.cnt != block.cnt + 1) insert(block);
            block.right.insert(node);
            blockMap.put(key, block.right);
            if (block.empty()) remove(block);
            return node.val;
        }
        public void put(int key, int value) {
            if (capacity == 0) return;
            if (blockMap.containsKey(key)) {
                nodeMap.get(key).val = value;
                get(key);
            }
            else {
                if (blockMap.size() == capacity) { // 容量满了
                    var p = head.right.tail.left;
                    head.right.remove(p);
                    if (head.right.empty()) remove(head.right);
                    blockMap.remove(p.key);
                    nodeMap.remove(p.key);
                }
                var p = new Node(key, value);
                if (head.right.cnt > 1) insert(head);
                head.right.insert(p);
                blockMap.put(key, head.right);
                nodeMap.put(key, p);
            }
        }
        // 在 p 的右侧插入新块，cnt 为 p.cnt + 1
        private void insert(Block p) {
            var cur = new Block(p.cnt + 1);
            cur.right = p.right;
            p.right.left = cur;
            p.right = cur;
            cur.left = p;
        }
        private void remove(Block p) {
            p.left.right = p.right;
            p.right.left = p.left;
        }
    }
    
    static class Node {
        int key;
        int val;
        Node left;
        Node right;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    static class Block {
        Node head;
        Node tail;
        Block left;
        Block right;
        int cnt;
        public Block(int cnt) {
            this.cnt = cnt;
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.right = tail; tail.left = head;
        }
        public void insert(Node p) {
            p.right = head.right;
            head.right.left = p;
            p.left = head;
            head.right = p;
        }
        public void remove(Node p) {
            p.left.right = p.right;
            p.right.left = p.left;
        }
        public boolean empty() {
            return head.right == tail;
        }
    }
}
