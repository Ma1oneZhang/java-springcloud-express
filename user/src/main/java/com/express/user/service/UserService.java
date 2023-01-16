package com.express.user.service;

import com.express.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.express.user.pojo.VO.UserLoginVo;
import com.express.user.pojo.VO.UserRegisterVO;

import java.io.UnsupportedEncodingException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzy
 * @since 2023-01-15 02:04:52
 */
public interface UserService extends IService<User> {
    User register(UserRegisterVO userRegisterVO) ;
    User login(UserLoginVo userLoginVo);
}
