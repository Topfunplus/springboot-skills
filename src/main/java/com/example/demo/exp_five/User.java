package com.example.demo.exp_five;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.UUID;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
// 自定义加载配置文件
@PropertySource(value = "classpath:exp-five.properties", encoding = "UTF-8")
@ConfigurationProperties

// JSR303数据校验
@Validated
public class User {
    private Integer id;

    @Email
    private String email;

    //    @UUID
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
