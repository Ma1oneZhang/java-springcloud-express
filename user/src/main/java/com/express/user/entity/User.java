package com.express.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.express.user.pojo.VO.UserRegisterVO;
import com.express.utils.SecuritySHA1Utils;
import com.fasterxml.jackson.databind.util.BeanUtil;
import io.swagger.annotations.ApiModel;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzy
 * @since 2023-01-15 02:04:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("nickname")
    private String nickname;

    @TableField("gender")
    private String gender;

    @TableField("telephone")
    private String telephone;

    @TableField("registerdate")
    private Date registerdate;

    @TableField("address")
    private String address;

    @TableField("photo")
    private String photo;

    @TableField("usertype")
    private Integer usertype;
}
