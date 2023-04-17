package com.java.demo;

import java.util.Date;

/**
 * @author zhangxq
 * @since 2023/3/28
 */
public class RecordDemo {
    
    public static void main(String[] args) {
        Duration spend = fun();
        System.out.println(spend.yongshi());
    }
    
    public static Duration fun() {
        Date start = new Date();
        
        // do something
        // xxx
        
        Date end = new Date();
        return new Duration(start, end);
    }
    
    public record Duration(Date start, Date end) {
        public String yongshi() {
            // this.end - this.start
            return "用时30分钟。";
        }
    }
}
