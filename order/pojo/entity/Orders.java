package order.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
    @ApiModel(value="Orders对象", description="")
public class Orders extends Model<Orders> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    @TableField("orderTime")
    private Date orderTime;

    private Integer userId;

    private Integer storeId;

    private Integer menuId;

    private String state;

    private Double cost;


    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
