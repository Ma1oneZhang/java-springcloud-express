package menu.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
    @ApiModel(value="TMenu对象", description="")
public class TMenu extends Model<TMenu> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private String name;

    private Double price;

    private String flavor;

    private String type;

    private String photo;

    private Integer storeId;


    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
