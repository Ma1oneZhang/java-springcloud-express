package com.express.menu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gqc
 * @since 2023-01-23
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuVo {
    private Integer id;
    private String name;
    private double price;
    private String flavor;
    private String type;
    private String photo;
    private Integer storeId;

}
