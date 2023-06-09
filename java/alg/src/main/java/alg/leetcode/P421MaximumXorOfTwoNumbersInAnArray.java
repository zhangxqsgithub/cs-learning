package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/
 * @author zhangxq
 * @since 2023/6/9
 */
public class P421MaximumXorOfTwoNumbersInAnArray {
    
    public static void main(String[] args) {
    
    }
    
    public int findMaximumXOR(int[] nums) {
        var t = new Trie();
        for (var x : nums) t.add(x);
        var res = 0;
        for (var x : nums) res = Math.max(res, t.query(x));
        return res;
    }
    static class Trie {
        TrieNode head;
        public Trie() { head = new TrieNode(); }
        public void add(int num) {
            TrieNode p = head;
            for (int i = 30; i >= 0; i--) {
                int v = num >> i & 1;
                if (p.children[v] == null) {
                    p.children[v] = new TrieNode();
                }
                p = p.children[v];
            }
        }
        
        public int query(int num) {
            int res = 0;
            TrieNode p = head;
            for (int i = 30; i >= 0; i--) {
                int v = num >> i & 1;
                if (p.children[1 ^ v] != null) {
                    res += 1 << i;
                    p = p.children[1 ^ v];
                }
                else {
                    p = p.children[v];
                }
            }
            return res;
        }
    }
    static class TrieNode {
        public TrieNode[] children;
        public TrieNode() { children = new TrieNode[2]; }
    }
}
