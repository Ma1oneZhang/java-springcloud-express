package com.express.user.controller;

import com.express.user.entity.User;
import com.express.user.pojo.VO.UserLoginVo;
import com.express.user.pojo.VO.UserRegisterVO;
import com.express.user.service.UserService;
import com.express.user.service.impl.UserServiceImpl;
import com.express.utils.ResponseResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

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
@Api(value="用户controller",tags={"用户操作接口"})
public class UserController {
    @Autowired
    private UserService userService = new UserServiceImpl();

    @PostMapping("/register")
    @ApiOperation(value = "注册")
    public ResponseResult Register(@RequestBody
                                       UserRegisterVO registerVO){
        return ResponseResult.okResult(userService.Register(registerVO));
    }

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public ResponseResult Login(@RequestBody
                                    UserLoginVo userLoginVo) {
        return ResponseResult.okResult(userService.Login(userLoginVo));
    }
}
