package com.express.user.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.express.user.pojo.DTO.UserDTO;
import com.express.user.pojo.VO.Auth.UserLoginVo;
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

//    @PostMapping("/login")
//    @ApiOperation(value = "登录")
//    public ResponseResult<UserDTO> login(@RequestBody
//                                    UserLoginVo userLoginVo) {
//        return userService.login(userLoginVo);
//    }


    @GetMapping("/test")
    public ResponseResult<Object> test(){
        return ResponseResult.okResult(new Object());
    }

    @GetMapping("/userinfo")
    @ApiOperation(value = "管理员获取用户信息")
    public ResponseResult<IPage<UserDTO>> userInfo(Integer pageNum, Integer pageSize){
        // 权限验证
        return userService.listAllUser(pageNum, pageSize);
    }

    @GetMapping("/myinfo")
    @ApiOperation(value = "用户获取自身信息")
    public ResponseResult<UserDTO> myInfo(Integer id){
        return userService.queryByUserId(id);
    }
}
