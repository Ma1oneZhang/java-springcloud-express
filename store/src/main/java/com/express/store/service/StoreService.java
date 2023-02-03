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
     * @param ownerId ownerId
     * @return 返回商店详细信息
     */
    ResponseResult createStores(StoreVo storeVo, Integer ownerId);

    /**
     * 通过id查询商家
     * @author gqc
     * @param storeId store_id
     * @return 返回商店详细信息
     */

    ResponseResult queryStoresByStoreId(Integer storeId);

    /**
     * 通过用户id查询商店
     * @author gqc
     * @param userId user_id
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return 返回商店详细信息
     */
    ResponseResult queryStoresByUserId(Integer userId, Integer pageNum, Integer pageSize);

    /**
     * 在数据库进行like搜索
     * @author zzy
     * @param name 商店名字
     * @param pageNum 页号
     * @param pageSize 页大小
     * @return 搜索得到的商店情况
     * */
    ResponseResult queryStoresByName(String name, Integer pageNum, Integer pageSize);

    /**
     * 通过主键删除
     * @author zzy
     * @param id 商店id
     * @return 搜索得到的商店情况
     * */
    ResponseResult deleteStoreById(Integer id);
}
