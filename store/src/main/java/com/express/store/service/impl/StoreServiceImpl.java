package com.express.store.service.impl;

import com.express.store.entity.Store;
import com.express.store.mapper.StoreMapper;
import com.express.store.pojo.StoreVo;
import com.express.store.service.StoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.express.utils.ResponseResult;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzy
 * @since 2023-01-15 02:20:46
 */
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store> implements StoreService {

    @Override
    public ResponseResult creatStores(StoreVo storeVo) {
        return null;
    }

    @Override
    public ResponseResult queryStoresById(Integer userId, Integer storeId, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public ResponseResult queryStoresByUserId(Integer userId, Integer pageNum, Integer pageSize) {
        return null;
    }
}
