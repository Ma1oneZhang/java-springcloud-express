package com.express.user.pojo.VO;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "User登录对象", description = "---")
public class UserLoginVo {
    private String username;
    private String password;
}
