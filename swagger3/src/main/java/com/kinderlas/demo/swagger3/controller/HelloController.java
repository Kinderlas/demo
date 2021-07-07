package com.kinderlas.demo.swagger3.controller;

import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/hello")
    public Response hello() {
        Response response = new Response();
        response.setData("hello");
        response.setMsg("success");
        response.setStatus(0);
        return response;
    }

}
