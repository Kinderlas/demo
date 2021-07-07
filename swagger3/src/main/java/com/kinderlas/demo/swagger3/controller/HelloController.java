package com.kinderlas.demo.swagger3.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kinderlas.demo.swagger3.controller.HelloController.HelloDTO.Type;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Data;

@RestController
@RequestMapping("/")
@Api(tags = "demo")
public class HelloController {

    @Data
    @ApiModel("hello返回")
    public static class Response {
        @ApiModelProperty("数据")
        String data;
        @ApiModelProperty("额外信息")
        String msg;
        @ApiModelProperty("状态")
        int status;

    }

    @Data
    @ApiModel("用户信息")
    public static class HelloDTO {

        @ApiModelProperty("姓名")
        String name;

        @ApiModelProperty("年龄")
        int age;

        @ApiModelProperty("哈哈")
        List<Integer> t;

        Type type;

        @ApiModel("用户类型")
        public enum Type {
            @ApiModelProperty("vip用户")
            vip,
            @ApiModelProperty("普通用户")
            normal
        }
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path"),
            @ApiImplicitParam(name = "forward", value = "ip", required = true, paramType = "header"),
    })
    @ApiResponses({
            @ApiResponse(code = 403, message = "无权限"),
            @ApiResponse(code = 404, message = "内部错误"),
    })
    @ApiOperation("hello get方法")
    @GetMapping("/hello/{id}")
    public Response hello(
            @PathVariable Integer id,
            @ApiParam(value = "姓名", required = true) String name,
            @ApiParam(value = "年龄") @RequestParam(defaultValue = "12") String age,
            @ApiParam("用户类型") @RequestParam(defaultValue = "vip") Type type
    ) {
        Response response = new Response();
        response.setData("hello " + name + ":" + age);
        response.setMsg("success");
        response.setStatus(0);
        return response;
    }

    // @ApiImplicitParams({
    //         @ApiImplicitParam(name = "pageNum", value = "当前页数"),
    //         @ApiImplicitParam(name = "pageSize", value = "每页记录数")
    // })
    @GetMapping("helloMap")
    public Response helloMap(
            @RequestParam Map<String, Object> param
    ) {
        Response response = new Response();
        response.setData("hello " + param.get("name") + ":" + param.get("age"));
        response.setMsg("success");
        response.setStatus(0);
        return response;
    }

    @ApiOperation("hello post方法")
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
