package com.express.user.pojo.VO;

import com.sun.istack.internal.NotNull;
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
    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String nickname;
    @NotNull
    private String gender;
    private String telephone;
    @NotNull
    private String userPhotoUrl;
    @NotNull
    private String address;
    @NotNull
    private Integer userType;
}
