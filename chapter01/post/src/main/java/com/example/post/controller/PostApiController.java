package com.example.post.controller;

import com.example.post.dto.PostRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public void post(@RequestBody PostRequest requestData){
        System.out.println(requestData.toString());
    }
}
