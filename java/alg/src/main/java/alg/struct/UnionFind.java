package alg.struct;

/**
 * 并查集
 * 1. 将两个集合合并
 * 2. 判断两个元素是否在一个集合中
 *
 * 基本原理：每个集合用一棵树来表示，树根的编号就是整合集合的编号。
 * 每个节点存储它的父节点，p[x] 表示 x 的父节点。
 * 判断一个节点是不是树根：if (p[x] == x)
 * 如何求 x 的集合编号：while(p[x] != x) x = p[x];
 * 如何合并两个集合：p[x] 是 x 的集合编号，p[y] 是 y 的集合编号，p[x] = y
 *
 * 优化：路经压缩
 */
public class UnionFind {
    
    private int count;
    
    private int[] parent;
    
    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        // 先是每一个元素都是自己为一组
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    
    /**
     * 返回 x 的祖宗节点，并且路经压缩
     */
    public int find(int x) {
        // 如果要找的元素不是头元素，则向上查找
        while (x != parent[x]) x = find(parent[x]);
        return x;
    }
    
    public void union(int p, int q) {
        parent[find(p)] = find(q);
        count--;
    }
    
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
    
    public int count() {
        return count;
    }
}
