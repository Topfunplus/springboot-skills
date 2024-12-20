package com.example.demo.exp_eight;

import lombok.Data;
import org.springframework.data.redis.core.index.Indexed;


@Data
public class Family {

    @Indexed
    private String type;

    private String username;

    public Family(String type, String username) {
        this.type = type;
        this.username = username;
    }


}
