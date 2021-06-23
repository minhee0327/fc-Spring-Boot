package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        var objectMapper = new ObjectMapper();

        //object -> text;
        //object mapper 가 get Method 를 사용한다.
        var user = new User("steve", 10, "010-1111-2222");
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        //text -> object;
        //object mapper 는 default constructor 기준으로 변환이 된다.
        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);
    }
}
