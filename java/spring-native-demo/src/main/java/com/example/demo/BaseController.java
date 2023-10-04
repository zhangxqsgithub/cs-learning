package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxq
 * @since 2023/10/4
 */
@RestController
public class BaseController {
    
    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }
    
}
