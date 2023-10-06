package alg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/find-duplicate-file-in-system/
 * @author zhangxq
 * @since 2023/10/6
 */
public class P609FindDuplicateFileInSystem {
    
    public static void main(String[] args) {
    
    }
    
    public List<List<String>> findDuplicate(String[] paths) {
        var map = new HashMap<String, List<String>>();
        for (var path : paths) {
            var files = path.split(" ");
            for (int i = 1; i < files.length; i++) {
                var file = files[i];
                var idx = file.indexOf("(");
                // 内容
                var content = file.substring(idx + 1);
                if (!map.containsKey(content)) map.put(content, new ArrayList<>());
                
                var list = map.get(content);
                list.add(files[0] + "/" + file.substring(0, idx));
            }
        }
        
        // 遍历一遍哈希表，如果值的长度大于 1 说明是答案
        List<List<String>> res = new ArrayList<>();
        for (var e : map.entrySet())
            if (e.getValue().size() > 1)
                res.add(e.getValue());
        return res;
    }
}
