package com.express.user.pojo.VO.Auth;

import com.express.user.pojo.DTO.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zzy
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserLoginResultVo {
    String token;

    UserDTO userDetail;
}
