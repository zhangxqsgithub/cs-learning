package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/serialize-and-deserialize-bst/
 * @since 2023/6/12
 */
public class P449SerializeAndDeserializeBst {
    
    public static void main(String[] args) {
        var solution = new Codec();
        var root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        var res = solution.serialize(root);
        System.out.println(res);
        
        var res2 = solution.deserialize(res);
    }
    
    static
    public class Codec {
        public String serialize(TreeNode root) {
            var res = new StringBuilder();
            dfs_s(root, res);
            return res.toString();
        }
        public void dfs_s(TreeNode root, StringBuilder sb) {
            if (root == null) return;
            sb.append(root.val).append(' ');
            dfs_s(root.left, sb);
            dfs_s(root.right, sb);
        }
        public TreeNode deserialize(String data) {
            if (data.isBlank()) return null;
            var list = new ArrayList<Integer>();
            var arr = data.split("\\s+");
            for (var str : arr) list.add(Integer.parseInt(str.trim()));
            return dfs_d(list, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        int u = 0;
        public TreeNode dfs_d(List<Integer> data, int min, int max) {
            if (u == data.size() || data.get(u) < min || data.get(u) > max) return null;
            var root = new TreeNode(data.get(u));
            u++;
            root.left = dfs_d(data, min, root.val);
            root.right = dfs_d(data, root.val, max);
            return root;
        }
    }
    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) {
            val = x;
        }
    }
}
