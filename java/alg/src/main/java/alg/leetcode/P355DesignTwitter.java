package alg.leetcode;

import java.util.*;

/**
 * @link https://leetcode.cn/problems/design-twitter/
 * @author zhangxq
 * @since 2023/6/1
 */
public class P355DesignTwitter {
    
    public static void main(String[] args) {
    
    }
    
    static
    class Twitter {
        // 存储每个用户关注了哪些用户
        Map<Integer, Set<Integer>> f;
        // 存每个用户按顺序发表的推特
        List<Pair> q;
        public Twitter() {
            f = new HashMap<>();
            q = new ArrayList<>();
        }
        public void postTweet(int userId, int tweetId) {
            if (!f.containsKey(userId)) f.put(userId, new HashSet<>());
            q.add(new Pair(userId, tweetId));
        }
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> res = new ArrayList<>();
            if (!f.containsKey(userId)) return res;
            var s = f.get(userId);
            for (int i = q.size() - 1; i >= 0; i--) {
                var cur = q.get(i);
                if (userId == cur.first || s.contains(cur.first)) {
                    res.add(cur.second);
                    if (res.size() == 10) break;
                }
            }
            return res;
        }
        public void follow(int followerId, int followeeId) {
            if (!f.containsKey(followerId)) f.put(followerId, new HashSet<>());
            f.get(followerId).add(followeeId);
        }
        public void unfollow(int followerId, int followeeId) {
            if (f.containsKey(followerId))
                f.get(followerId).remove(followeeId);
        }
    }
    record Pair(int first, int second) {}
}
