package alg.leetcode;

import java.util.List;

/**
 * @link https://leetcode.cn/problems/mini-parser/
 * @author zhangxq
 * @since 2023/6/6
 */
public class P385MiniParser {
    
    public static void main(String[] args) {
        String s = "[123,[456,[789]]]";
    }
    
    int u;
    public NestedInteger deserialize(String s) {
        u = 0;
        return dfs(s);
    }
    public NestedInteger dfs(String s) {
        if (u == s.length()) return null;
        NestedInteger res = new NestedIntegerImpl();
        if (s.charAt(u) == '[') { // 如果是内部节点
            u++; // 跳过左括号
            while (s.charAt(u) != ']') { res.add(dfs(s)); }
            u++; // 跳过右括号
            if (u < s.length() && s.charAt(u) == ',') u++; // 跳过逗号
        }
        else {
            int k = u;
            while (k < s.length() && s.charAt(k) != ',' && s.charAt(k) != ']') k++;
            res.setInteger(Integer.parseInt(s.substring(u, k)));
            if (k < s.length() && s.charAt(k) == ',') k++; // 跳过逗号
            u = k;
        }
        return res;
    }
    
    
    interface NestedInteger {
        // Constructor initializes an empty nested list.
        // public NestedInteger();
        // Constructor initializes a single integer.
        // public NestedInteger(int value);
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();
        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();
        // Set this NestedInteger to hold a single integer.
        void setInteger(int value);
        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        void add(NestedInteger ni);
        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }
    static class NestedIntegerImpl implements NestedInteger {
        @Override
        public boolean isInteger() {
            return false;
        }
        @Override
        public Integer getInteger() {
            return null;
        }
        @Override
        public void setInteger(int value) {
        }
        @Override
        public void add(NestedInteger ni) {
        }
        @Override
        public List<NestedInteger> getList() {
            return null;
        }
    }
}
