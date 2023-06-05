package alg.leetcode;

import java.util.*;

/**
 * @link https://leetcode.cn/problems/insert-delete-getrandom-o1/
 * @author zhangxq
 * @since 2023/6/5
 */
public class P380InsertDeleteGetrandomO1 {
    
    public static void main(String[] args) {
        var solution = new RandomizedSet();
        solution.remove(0);
        solution.remove(0);
        solution.insert(0);
        solution.getRandom();
        solution.remove(0);
        var res = solution.insert(0);
        System.out.println(res);
    }
    
    static
    class RandomizedSet {
        List<Integer> list;
        Map<Integer, Integer> map;
        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
        }
        
        public boolean insert(int val) {
            if (!map.containsKey(val)) {
                list.add(val);
                map.put(val, list.size() - 1);
                return true;
            }
            else return false;
        }
        
        public boolean remove(int val) {
            if (map.containsKey(val)) {
                int idx = map.get(val);
                if (idx != list.size() - 1) {
                    Integer last = list.get(list.size() - 1);
                    list.set(list.size() - 1, val);
                    list.set(idx, last);
                    map.put(last, idx);
                }
                map.remove(val);
                list.remove(list.size() - 1);
                return true;
            }
            else return false;
        }
        
        public int getRandom() {
            Random random = new Random();
            int idx = random.nextInt(0, list.size());
            return list.get(idx);
        }
    }
}
