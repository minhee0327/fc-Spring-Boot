package com.example.hello.controller;

import com.example.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    //http://localhost:9090/api/get/hello
    @GetMapping(path = "/hello")
    public String getHello() {
        return "get Hello";
    }

    //http://localhost:9090/api/get/hi
    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    public String hi() {
        return "hi";
    }

    //http://localhost:9090/api/get/path-variable/{name}
    //name 은 고정된 값이 아니라 변화하는 값
    //url 에서는 대문자를 사용하지 않는게 좋다.
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName) {
        System.out.println("PathVariable: " + pathName);
        return pathName;
    }

    //query-parameter
    // http://localhost:9090/api/get/query-param?user=mini&email=lee@naver.com&age=30
    // key-value 형태이니까 Map 으로 받을 수 있다.
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {
        StringBuilder sb = new StringBuilder();
        queryParam.forEach((key, value) -> {
            System.out.println(key + " " + value);
            sb.append(key).append(" = ").append(value).append("\n");
        });
        return sb.toString();
    }

    //명시적으로 매개변수 받기
    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name + " " + email + " " + age;
    }

    //DTO 활용
    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest) {
        String name = userRequest.getName();
        String email = userRequest.getEmail();
        int age = userRequest.getAge();

        System.out.println(name +" " + email + " " +age);

        return userRequest.toString();
    }
}
