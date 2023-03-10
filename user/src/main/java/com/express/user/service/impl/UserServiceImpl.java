package com.express.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.express.enums.ResultCode;
import com.express.exceptions.exception.UserException;
import com.express.user.entity.User;
import com.express.user.mapper.UserMapper;
import com.express.user.pojo.DTO.UserDTO;
import com.express.user.pojo.VO.Auth.UserLoginVo;
import com.express.user.pojo.VO.UserRegisterVO;
import com.express.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.express.utils.PageUtils;
import com.express.utils.ResponseResult;
import com.express.utils.SecuritySHA1Utils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.express.utils.RegExpressionCheck.checkPas;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzy
 * @since 2023-01-15 02:04:52
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public ResponseResult<UserDTO> register(UserRegisterVO userRegisterVO){
        if(userRegisterVO.getGender() == null || userRegisterVO.getGender().length() > 1) {
            throw new UserException(ResultCode.USER_ACCOUNT_ALREADY_EXIST);
        }
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", userRegisterVO.getUsername());
        if(count(wrapper) > 0){
            throw new UserException(ResultCode.USER_ACCOUNT_ALREADY_EXIST);
        }
        if(!checkPas(userRegisterVO.getPassword())){
            throw new UserException(ResultCode.PASSWORD_TOO_WEAK);
        }
        userRegisterVO.setPassword(SecuritySHA1Utils.shaEncode(userRegisterVO.getPassword()));
        User newUser = toUserEntity(userRegisterVO);
        // extended in ServiceImpl<UserMapper, User>
        // includes baseMapper inside
        save(newUser);
        UserDTO userDTO = userEntityToOthers(UserDTO.class, newUser);
        return ResponseResult.okResult(newUser);
    }

    @SneakyThrows
    @Override
    public ResponseResult<UserDTO> login(UserLoginVo userLoginVo){
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("username", userLoginVo.getUsername())
                .eq("password", SecuritySHA1Utils.shaEncode(userLoginVo.getPassword()));
        User user = getOne(query);
        if(user == null){
            throw new UserException(ResultCode.USER_CREDENTIALS_ERROR);
        }
        return ResponseResult.okResult(userEntityToOthers(UserDTO.class, user));
    }

    @Override
    public ResponseResult<IPage<UserDTO>> listAllUser(Integer pageNum, Integer pageSize) {
        IPage<User> iPage = PageUtils.getPage(pageNum, pageSize, User.class);
        page(iPage, new QueryWrapper<User>());
        PageUtils pageUtils = new PageUtils<>(iPage);
        List<User> result =  pageUtils.getList();
        pageUtils.setList(listUserEntityToOthers(UserDTO.class, result));
        return ResponseResult.okResult(pageUtils);
    }

    @Override
    public ResponseResult<UserDTO> queryByUserId(Integer id) {
        User user = getById(id);
        if(user == null){
            throw new UserException(ResultCode.USER_ACCOUNT_NOT_EXIST);
        }
        return ResponseResult.okResult(userEntityToOthers(UserDTO.class, user));
    }

    /**
     * @author zzy
     * @describe Do as you think
     * @since 2023-01-19 19:21
     * */
    private User toUserEntity(Object object){
        User user = new User();
        BeanUtils.copyProperties(object, user);
        return user;
    }


    /**
     * @author zzy
     * @describe Do as you think
     * @since 2023-01-19 19:21
     * */
    @SneakyThrows
    private <T> T userEntityToOthers(Class<T> c, User user){
        T object = c.newInstance();
        BeanUtils.copyProperties(user, object);
        return object;
    }

    /**
     * @author zzy
     * @describe Do as you think
     * @since 2023-01-19 19:35
     * */
    private <T> List<T> listUserEntityToOthers(Class<T> c, List<User> users){
        List<T> list = new ArrayList<>();
        for (User user : users) {
            list.add(userEntityToOthers(c, user));
        }
        return list;
    }
}
