package com.express.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.express.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.express.user.pojo.DTO.UserDTO;
import com.express.user.pojo.VO.Auth.UserLoginVo;
import com.express.user.pojo.VO.UserRegisterVO;
import com.express.utils.ResponseResult;

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
    ResponseResult<UserDTO> register(UserRegisterVO userRegisterVO) ;

    /**
     * 用户登录
     *
     * @author zzy
     * @param userLoginVo 用户登录的VO
     * @return 如果账号密码匹配 返回用户数据 */
    ResponseResult<UserDTO> login(UserLoginVo userLoginVo);

    /**
     * 获取所有用户信息 （admin）
     *
     * @author zzy
     * @param pageNum 前端所需要的页数
     * @param pageSize 每页的大小
     * @return 所有用户信息
     * @warning 未加上管理员权限
     * */
    ResponseResult<IPage<UserDTO>> listAllUser(Integer pageNum, Integer pageSize);


    /**
     * 获取所有用户信息 （admin）
     *
     * @author zzy
     * @param id
     * @return 对应用户信息
     * @warning 未加上管理员权限
     * */
    ResponseResult<UserDTO> queryByUserId(Integer id);
}
