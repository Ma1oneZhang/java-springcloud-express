package com.express.user.mapper;

import com.express.user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzy
 * @since 2023-01-15 02:04:52
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
