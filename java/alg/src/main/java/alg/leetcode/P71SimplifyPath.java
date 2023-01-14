package alg.leetcode;

/**
 * 简化路径
 *
 * @author zhangxq
 * @link https://leetcode.cn/problems/simplify-path/
 * @since 2023/1/14
 */
public class P71SimplifyPath {
    
    public static void main(String[] args) {
    
    }
    
    public String simplifyPath(String path) {
        String res = "", name = "";
        if (path.charAt(path.length() - 1) != '/') path += '/';
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c != '/') name += c;
            else {
                if (name.equals("..")) {
                    while (res.length() != 0 && res.charAt(res.length() - 1) != '/') {
                        res = res.substring(0, res.length() - 1);
                    }
                    if (res.length() != 0) {
                        res = res.substring(0, res.length() - 1);
                    }
                }
                else if (!name.equals(".") && !name.equals("")) {
                    res += "/" + name;
                }
                name = "";
            }
        }
        if (res.length() == 0) res = "/";
        return res;
    }
}
