package com.express.store.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.express.enums.ResultCode;
import com.express.store.entity.Store;
import com.express.store.mapper.StoreMapper;
import com.express.store.pojo.StoreVo;
import com.express.store.service.StoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.express.utils.PageUtils;
import com.express.utils.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public ResponseResult createStores(StoreVo storeVo, Integer ownerId) {
        Store store = new Store();
        store.setUserId(ownerId);
        BeanUtils.copyProperties(storeVo, store);
        save(store);
        return ResponseResult.okResult(storeVo);
    }

    @Override
    public ResponseResult queryStoresByStoreId(Integer storeId) {
        Store store = getById(storeId);
        if(store == null){
            return ResponseResult.errorResult(ResultCode.STORE_NOT_EXIST);
        }else{
            return ResponseResult.okResult(store);
        }
    }

    @Override
    public ResponseResult queryStoresByUserId(Integer userId, Integer pageNum, Integer pageSize) {
        QueryWrapper<Store> query = new QueryWrapper<>();
        query.eq("user_id", userId);
        IPage<Store> list = page(PageUtils.getPage(pageNum, pageSize, Store.class), query);
        return ResponseResult.okResult(list);
    }

    @Override
    public ResponseResult queryStoresByName(String name, Integer pageNum, Integer pageSize) {
        IPage page = PageUtils.getPage(pageNum, pageSize, Store.class);
        page(page, new QueryWrapper<Store>().like("storename", name));
        PageUtils pages = new PageUtils(page);
        pages.setList(toStoreVoList(pages.getList()));
        return ResponseResult.okResult(pages);
    }

    @Override
    public ResponseResult deleteStoreById(Integer id) {
        Store store = getById(id);
        if(removeById(id)){
            return ResponseResult.okResult();
        }
        return ResponseResult.errorResult(ResultCode.STORE_NOT_EXIST);
    }

    private StoreVo toStoreVo(Store store){
        StoreVo storeVo = new StoreVo();
        BeanUtils.copyProperties(store, storeVo);
        return storeVo;
    }
    private List<StoreVo> toStoreVoList(List<Store> list){
        List<StoreVo> result = new ArrayList<>();
        for(Store i : list){
            result.add(toStoreVo(i));
        }
        return result;
    }
}
