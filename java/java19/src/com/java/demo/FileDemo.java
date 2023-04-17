package com.java.demo;

import java.io.File;
import java.io.IOException;

/**
 * @author zhangxq
 * @since 2023/3/27
 */
public class FileDemo {
    
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/zail/test.txt");
        System.out.println(file);
        System.out.println("是否存在：" + file.exists());
        // 创建文件
        boolean newFile = file.createNewFile();
        System.out.println("是否为文件：" + file.isFile());
        
        // 删除文件
        boolean del = file.delete();
    }
    
}
