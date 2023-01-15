package com.express.user.pojo.VO;

import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "User注册对象", description = "---")
public class UserRegisterVO {
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String telephone;
    private String userPhotoUrl;
    private String address;
    private Integer userType;
}
