package com.example.study.controller;

import com.example.study.model.SearchParam;
import com.example.study.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GetController {

    @RequestMapping(method= RequestMethod.GET, path="/getMethod")
    public String getRequest(){
        return "hi getMethod";
    }

    @GetMapping("/getParameter")
    public String getParameter(@RequestParam String id, @RequestParam(name="password") String pw){
        System.out.println("id: " + id + " pw: "+ pw);
        return id+pw;
    }

    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        //{"account":"", "email":"", "page":0}
        return searchParam;
    }

    @GetMapping("/header")
    public Header getHeader(){
        // {"resultCode":"ok", "description": "ok"}
        return Header.builder().resultCode("OK").description("OK").build();
    }
}
