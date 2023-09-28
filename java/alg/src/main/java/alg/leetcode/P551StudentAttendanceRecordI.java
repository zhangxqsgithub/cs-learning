package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/student-attendance-record-i/
 * @author zhangxq
 * @since 2023/9/28
 */
public class P551StudentAttendanceRecordI {
    
    public static void main(String[] args) {
    
    }
    
    public boolean checkRecord(String s) {
        for (int i = 0, a = 0, l = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if (c == 'A') { a++; l = 0; }
            else if (c == 'L') l++;
            else l = 0;
            
            if (a > 1 || l > 2) return false;
        }
        return true;
    }
}
