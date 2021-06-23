package com.example.put.controller;

import com.example.put.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put")
    public PutRequestDto put(@RequestBody PutRequestDto requestDto){
        System.out.println(requestDto);
        return requestDto;
    }

    @PutMapping("/put01/{userId}")
    public PutRequestDto put01(@ RequestBody PutRequestDto requestDto, @PathVariable(name="userId") Long id){
        System.out.println(id);
        return requestDto;
    }
}
