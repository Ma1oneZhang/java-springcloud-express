package com.express.user.pojo.VO.Auth;

import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zzy
 * @since 2023-01-15 02:04:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "User登录对象", description = "---")
public class UserLoginVo {
    @NotNull
    private String username;
    @NotNull
    private String password;
}
