package com.java.demo;

import java.util.Date;

/**
 * @author zhangxq
 * @since 2023/3/28
 */
public class RCD {
    
    public record Pair<T1, T2>(T1 val1, T2 val2) {
    }
    
    public record Duration(Date start, Date end) {
    }
    
}
