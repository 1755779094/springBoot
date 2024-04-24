package com.example.springboot001.controller;

import com.example.springboot001.pojo.Result;
import com.example.springboot001.service.TdeptService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private TdeptService tdeptService;

    @RequestMapping("/findUser")
    public String findUser(){
        System.out.println("斤斤计较");
        System.out.println(tdeptService.findUser());
        return "{'发挥':'这是json 吗'}";
    }

    //@Pattern(regexp = "正则表达式"
    @RequestMapping("/add")
    public Result add(@Pattern(regexp = "^abc 9$") String userName, String pwd){
        if(userName!= null && pwd!= null){
            tdeptService.add(userName, pwd);
        }else{
            return Result.errorr("参数不正确");
        }

        return  Result.success();
    }


}
