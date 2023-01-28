package com.express.user.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.express.user.pojo.DTO.UserDTO;
import com.express.user.pojo.VO.UserLoginVo;
import com.express.user.pojo.VO.UserRegisterVO;
import com.express.user.service.UserService;
import com.express.user.service.impl.UserServiceImpl;
import com.express.utils.ResponseResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzy
 * @since 2023-01-15 02:04:52
 */
@RestController
@RequestMapping("/user")
@Api(value="用户controller", tags={"用户操作接口"})
public class UserController {
    @Autowired
    private UserService userService = new UserServiceImpl();

    @PostMapping("/register")
    @ApiOperation(value = "注册")
    public ResponseResult<UserDTO> register(@RequestBody
                                       UserRegisterVO registerVO){
        return userService.register(registerVO);
    }

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public ResponseResult<UserDTO> login(@RequestBody
                                    UserLoginVo userLoginVo) {
        return userService.login(userLoginVo);
    }

    @GetMapping("/userinfo")
    @ApiOperation(value = "管理员获取用户信息")
    public ResponseResult<IPage<UserDTO>> userInfo(Integer pageNum, Integer pageSize){
        return userService.listAllUser(pageNum, pageSize);
    }
}
