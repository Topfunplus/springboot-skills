package com.example.demo.exp_eight;

import lombok.Data;
import org.springframework.data.redis.core.index.Indexed;


@Data
public class Address {

    @Indexed
    private String city;

    @Indexed
    private String country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

}
