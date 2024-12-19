package com.example.demo;

import com.example.demo.exp_two.domain.Person;
import com.example.demo.exp_two.domain.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private Person person;
    @Autowired
    private Pet pet;

    @Test
    void exp_three_test() {
        /**
         * Person{type='student', name='John Doe'}
         * Pet{name='Tom', type='cat', friends=[Jerry, Spike], hobbies=[running, sleeping], score={english=90, math=80, science=70},
         * category=Category{name='husky', type='null'}}
         */
        System.out.println(person.toString());
        System.out.println(pet.toString());
    }

}
