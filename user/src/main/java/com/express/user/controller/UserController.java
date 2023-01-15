package com.express.user.controller;

import com.express.user.entity.User;
import com.express.user.pojo.VO.UserRegisterVO;
import com.express.utils.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzy
 * @since 2023-01-15 02:04:52
 */
@RestController
@RequestMapping("/api/user")
@Api
public class UserController {

    @PostMapping("/register")
    public ResponseResult Register(@RequestBody UserRegisterVO registerVO){
        return ResponseResult.okResult(registerVO);
    }
}
