package com.mjq.bigevent.controller;

import com.mjq.bigevent.pojo.Result;
import com.mjq.bigevent.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/article")
public class ArtcleController {

//    Authorization
    @GetMapping("/list")
    public Result<String> list(){

        return Result.success("查询成功");
    }
}
