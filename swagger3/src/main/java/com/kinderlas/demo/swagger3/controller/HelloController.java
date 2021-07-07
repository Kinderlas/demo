package com.kinderlas.demo.swagger3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@RequestMapping("/")
public class HelloController {

    @Data
    public static class Response {
        String data;
        String msg;
        int status;
    }

    @Data
    public static class HelloDTO {
        String name;
        int age;
    }

    @GetMapping("/hello")
    public Response hello(String name) {
        Response response = new Response();
        response.setData("hello " + name);
        response.setMsg("success");
        response.setStatus(0);
        return response;
    }

    @PostMapping("/hello")
    public Response helloPost(
            @RequestBody HelloDTO helloDTO
    ) {
        Response response = new Response();
        response.setData("hello " + helloDTO.name + ":" + helloDTO.age);
        response.setMsg("success");
        response.setStatus(0);
        return response;
    }

}
