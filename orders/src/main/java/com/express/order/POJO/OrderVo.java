package com.express.order.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gqc
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderVo {
    private String orderTime;
    private int userId;
    private int storeId;
    private int menuId;
    private String state;
    private double cost;
}
