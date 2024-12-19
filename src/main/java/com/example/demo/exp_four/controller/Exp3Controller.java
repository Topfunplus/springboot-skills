package com.example.demo.exp_four.controller;

import com.example.demo.exp_two.domain.Person;
import com.example.demo.exp_two.domain.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exp3")
public class Exp3Controller {

    @Autowired
    private Person person;

    @Autowired
    private Pet pet;

    @RequestMapping("/index")
    public String index() {
        return person.toString() + "\n" + pet.toString();
    }
}
