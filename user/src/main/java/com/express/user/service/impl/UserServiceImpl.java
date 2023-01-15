package com.express.user.service.impl;

import com.express.enums.ResultCode;
import com.express.exceptions.exception.UserException;
import com.express.user.entity.User;
import com.express.user.mapper.UserMapper;
import com.express.user.pojo.VO.UserLoginVo;
import com.express.user.pojo.VO.UserRegisterVO;
import com.express.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.express.utils.SecuritySHA1Utils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    @Autowired
    UserMapper userMapper;

    @Override
    public User Register(UserRegisterVO userRegisterVO){
        Map<String, Object> query = new HashMap<>();
        query.put("username", userRegisterVO.getUsername());
        if(userMapper.selectByMap(query).size() > 0){
            throw new UserException(ResultCode.USER_ACCOUNT_ALREADY_EXIST);
        }
        if(!checkPas(userRegisterVO.getPassword())){
            throw new UserException(ResultCode.PASSWORD_TOO_WEAK);
        }
        User newUser = new User(userRegisterVO);
        userMapper.insert(newUser);
        return newUser;
    }
    public static boolean checkPas(String pas) {
        Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$");
        Matcher matcher = pattern.matcher(pas);
        return matcher.matches();
    }
    @SneakyThrows
    @Override
    public User Login(UserLoginVo userLoginVo){
        Map<String, Object> query = new HashMap<>();
        query.put("username", userLoginVo.getUsername());
        query.put("password", SecuritySHA1Utils.shaEncode(userLoginVo.getPassword()));
        List<User> result = userMapper.selectByMap(query);
        if(result.size() == 0){
            throw new UserException(ResultCode.USER_ACCOUNT_NOT_EXIST);
        }else{
            return result.get(0);
        }
    }
}
