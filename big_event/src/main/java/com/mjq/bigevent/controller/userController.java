package com.mjq.bigevent.controller;


import com.mjq.bigevent.pojo.Result;
import com.mjq.bigevent.pojo.User;
import com.mjq.bigevent.service.UserService;
import com.mjq.bigevent.utils.JwtUtil;
import com.mjq.bigevent.utils.Md5Util;
import com.mjq.bigevent.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/***
 *引入validation
 *全局异常处理
 */
@Validated
@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String userName, @Pattern(regexp = "^\\S{5,16}$")String password){
        User us  = userService.findUser(userName);
        if(us!=null){
            return Result.error("用户名已被占用！");
        }
        userService.add(userName,password);
        return Result.success();
    }


    /*
    * 登录
    * */
    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username,
                                @Pattern(regexp = "^\\S{5,16}$")String password){
        User loginUser = userService.findUser(username);
        if(loginUser==null){
            return Result.error("用户不存在");
        }
        String md5pwd = Md5Util.getMD5String(password);
        if(!md5pwd.equals(loginUser.getPassword())){
            return Result.error("密码不正确！");
        }
        // 登录成功 生成JWT token
        Map map = new HashMap<String,Object>();
        map.put("id",loginUser.getId() );
        map.put("username", loginUser.getUsername());
        String token = JwtUtil.genToken(map);
        return Result.success(token);
    }

    //获取用户信息
    @GetMapping("/userInfo")
    public Result<User> userInfo(){
       Map map =  ThreadLocalUtil.get();
        String userName = (String) map.get("username");
        User user = userService.findUser(userName);
        return Result.success(user);
    }

}
