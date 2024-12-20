package com.example.demo.exp_eight;

import jakarta.persistence.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;


@RedisHash("Person")
public class Person {
    @Id
    private String id;

    @Indexed
    private String name;

    @Indexed
    private Family family;

    @Indexed
    private Address address;

    public Person(String id, String name, Family family, Address address) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", family=" + family +
                ", address=" + address +
                '}';
    }
}
