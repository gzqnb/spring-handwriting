package com.gzq;

import com.spring.GzqApplicationContext;

/**
 * @Auther: gzq
 * @Date: 2021/4/22 - 04 - 22 - 18:16
 * @Description: com.gzq
 */
public class Test {
    public static void main(String[] args) {
        GzqApplicationContext applicationContext = new GzqApplicationContext(AppConfig.class);
        Object userService = applicationContext.getBean("userService");
    }
}
