package com.express.store.service;

import com.express.store.entity.Store;
import com.baomidou.mybatisplus.extension.service.IService;
import com.express.store.pojo.StoreVo;
import com.express.utils.ResponseResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzy
 * @since 2023-01-15 02:20:46
 */
public interface StoreService extends IService<Store> {
    /**
     * 创建商家
     * @author gqc
     * @param storeVo storeVo
     * @return 返回商家详细信息
     */
    ResponseResult creatStores(StoreVo storeVo);

    /**
     * 通过id查询商家
     * @author gqc
     * @param storeId store_id
     * @param userId user_id
     * @param pageSize pageSize
     * @param pageNum pageNum
     * @return 返回商家详细信息
     */

    ResponseResult queryStoresById(Integer userId, Integer storeId, Integer pageNum, Integer pageSize);

    /**
     * 通过用户id查询商家
     * @author gqc
     * @param userId user_id
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return 返回商家详细信息
     */

    ResponseResult queryStoresByUserId(Integer userId, Integer pageNum, Integer pageSize);
}
