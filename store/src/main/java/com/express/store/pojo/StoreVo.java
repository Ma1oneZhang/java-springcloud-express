package com.express.store.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gqc
 * @since 2023-01-23 22:49:53
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StoreVo {
    private int user_id;
    private String storename;
    private String address;
    private String telephone;
    private String photo;
}
