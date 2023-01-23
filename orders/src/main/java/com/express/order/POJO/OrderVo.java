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
    private int user_id;
    private int store_id;
    private int menu_id;
    private String state;
    private double cost;
}
