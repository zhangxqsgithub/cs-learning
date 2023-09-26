package alg.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @link https://leetcode.cn/problems/encode-and-decode-tinyurl/
 * @author zhangxq
 * @since 2023/9/26
 */
public class P535EncodeAndDecodeTinyurl {
    
    public static void main(String[] args) {
    
    }
    
    static class Codec {
        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random();
        Map<String, String> map = new HashMap<>();
        int len = 6;
        public String encode(String longUrl) {
            while (true) {
                String shortUrl = randomStr(len);
                if (!map.containsKey(shortUrl)) {
                    map.put(shortUrl, longUrl);
                    return "http://tinyurl.com/" + shortUrl;
                }
            }
        }
        public String decode(String shortUrl) {
            shortUrl = shortUrl.substring(shortUrl.length() - len);
            return map.get(shortUrl);
        }
        private String randomStr(int k) {
            var res = new StringBuilder();
            while (k-- > 0) res.append(chars.charAt(rand.nextInt(chars.length())));
            return res.toString();
        }
    }
}
