package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
// exp_three 为启动类添加注解 让springboot启动时加载指定的配置文件
@PropertySource(value = "classpath:application-exp-three.properties", encoding = "UTF-8")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
