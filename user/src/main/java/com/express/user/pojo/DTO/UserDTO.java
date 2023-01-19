package com.express.user.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zzy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String username;
    private String nickname;
    private String gender;
    private String telephone;
    private String userPhotoUrl;
    private String address;
    private Integer userType;
}
