package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
// -exp_three 为启动类添加注解 让springboot启动时加载指定的配置文件 properties文件PropertySource注解
//@PropertySource(value = "classpath:application-exp-three.properties", encoding = "UTF-8")

// -exp_four 为启动类添加注解 让springboot启动时加载指定的配置文件

// -exp_five
@ImportResource("classpath:beans.xml")

@ServletComponentScan

// -exp_eighteen
@EnableAsync
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
