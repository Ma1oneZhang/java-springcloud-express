package com.express.store.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zzy
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StoreCreateVo extends StoreVo{
    private Integer userId;
}
