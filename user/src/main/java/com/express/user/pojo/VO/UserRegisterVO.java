package com.express.user.pojo.VO;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zzy
 * @since 2023-01-15 02:04:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "User注册对象", description = "---")
public class UserRegisterVO implements Serializable {

    private String username;


    private String password;

    private String nickname;
    private String gender;
    private String telephone;
    private String userPhotoUrl;
    private String address;
    private Integer userType;
}
