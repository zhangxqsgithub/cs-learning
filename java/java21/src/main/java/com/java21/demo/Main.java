package com.java21.demo;

/**
 * @author zhangxq
 * @since 2023/10/14
 */
public class Main {
    
    public static void main(String[] args) {
        System.getProperties().forEach(
                (a, b) -> {
                    System.out.println(a.toString() + ": " + b);
                }
        );
        
        var javaVersion = System.getProperty("java.vm.version");
        System.out.println("Java Version: " + javaVersion);
    }
}
