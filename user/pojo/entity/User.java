package user.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author gouqichun
 * @since 2023-01-12
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @ApiModel(value="User对象", description="")
public class User extends Model<User> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private String username;

    private String password;

    private String nickname;

    private String gender;

    private String telephone;

    private Date registerdate;

    private String address;

    private String photo;

    private Integer usertype;


    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
