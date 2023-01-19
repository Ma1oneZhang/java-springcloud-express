package com.express.user.controller;

import com.express.user.pojo.VO.UserLoginVo;
import com.express.user.pojo.VO.UserRegisterVO;
import com.express.user.service.UserService;
import com.express.user.service.impl.UserServiceImpl;
import com.express.utils.ResponseResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api(value="用户controller", tags={"用户操作接口"})
public class UserController {
    @Autowired
    private UserService userService = new UserServiceImpl();

    @PostMapping("/register")
    @ApiOperation(value = "注册")
    public ResponseResult register(@RequestBody
                                       UserRegisterVO registerVO){
        return ResponseResult.okResult(userService.register(registerVO));
    }

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public ResponseResult login(@RequestBody
                                    UserLoginVo userLoginVo) {
        return ResponseResult.okResult(userService.login(userLoginVo));
    }

    @GetMapping("/userinfo")
    @ApiOperation(value = "管理员获取用户信息")
    public ResponseResult userInfo(Integer pageNum, Integer pageSize){
        return ResponseResult.okResult(userService.listAllUser(pageNum, pageSize));
    }
}
