package com.express.user.service;

import com.express.enums.ResultCode;
import com.express.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.express.user.pojo.VO.UserLoginVo;
import com.express.user.pojo.VO.UserRegisterVO;
import com.express.utils.ResponseResult;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzy
 * @since 2023-01-15 02:04:52
 */
public interface UserService extends IService<User> {
    /**
     * 用户注册
     *
     * @author zzy
     * @param userRegisterVO 用户登录的VO
     * @return 如果账号密码匹配 返回用户数据 */
    ResponseResult register(UserRegisterVO userRegisterVO) ;

    /**
     * 用户登录
     *
     * @author zzy
     * @param userLoginVo 用户登录的VO
     * @return 如果账号密码匹配 返回用户数据 */
    ResponseResult login(UserLoginVo userLoginVo);

    /**
     * 获取所有用户信息 （admin）
     *
     * @author zzy
     * @param pageNum 前端所需要的页数
     * @param pageSize 每页的大小
     * @return 所有用户信息
     * */
    ResponseResult listAllUser(Integer pageNum, Integer pageSize);
}
