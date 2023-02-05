package com.express.user.controller;

import com.express.user.pojo.VO.Auth.UserLoginVo;
import com.express.user.service.impl.UserServiceImpl;
import com.express.utils.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzy
 */
@RestController
@Api(value="用户认证controller", tags={"用户认证接口"})
public class AuthController {
    @Autowired
    private UserServiceImpl userService = new UserServiceImpl();

    @PostMapping("/login")
    public ResponseResult login(@RequestBody UserLoginVo userLoginVo){
        return userService.login(userLoginVo);
    }
    @GetMapping("/refresh_login")
    public ResponseResult refresh_login(){
        return ResponseResult.okResult();
    }

    @PostMapping("/logout")
    @GetMapping("/logout")
    public ResponseResult logout(){
        return ResponseResult.okResult();
    }
}
