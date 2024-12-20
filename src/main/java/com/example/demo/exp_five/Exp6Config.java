package com.example.demo.exp_five;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Exp6Config {

    @Bean
    public Exp61Service getExp6Service() {
        return new Exp61Service();
    }
}
