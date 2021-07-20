package com.fastcampus.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void test(){
        User user = new User();
        user.setEmail("mini@campus.com");
        user.setName("mini");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        User user1 = new User(null, "mini", "@gmal", LocalDateTime.now(), LocalDateTime.now());
        User user2 = new User("mini", "naver.com");
        User user3 = User.builder().name("min").email("hello").build();

        System.out.println(">>>"+user3);
    }

}