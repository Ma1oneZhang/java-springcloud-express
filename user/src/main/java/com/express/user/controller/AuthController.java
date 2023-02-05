package com.express.user.controller;

import com.express.enums.ResultCode;
import com.express.exceptions.exception.UserException;
import com.express.user.pojo.VO.Auth.UserLoginResultVo;
import com.express.user.pojo.VO.Auth.UserLoginVo;
import com.express.user.service.UserService;
import com.express.user.service.impl.UserServiceImpl;
import com.express.utils.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zzy
 */
@Controller
@Api(value="用户认证controller", tags={"用户认证接口"})
public class AuthController {
    @Autowired
    private UserServiceImpl userService = new UserServiceImpl();

    @PostMapping("/login")
    public ResponseResult<UserLoginResultVo> login(@RequestBody UserLoginVo userLoginVo){
        if(!userService.login(userLoginVo)){
            throw new UserException(ResultCode.USER_CREDENTIALS_ERROR);
        }
        return ResponseResult.okResult();
    }
    @GetMapping("/refresh_login")
    public ResponseResult refresh_login(){
        return ResponseResult.okResult();
    }

    @PostMapping
    @GetMapping
    public ResponseResult logout(){
        return ResponseResult.okResult();
    }
}
