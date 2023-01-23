package com.express.store.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.express.store.entity.Store;
import com.express.store.pojo.StoreVo;
import com.express.store.service.StoreService;
import com.express.store.service.impl.StoreServiceImpl;
import com.express.utils.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzy gqc
 * @since 2023-01-15 02:20:46
 */
@RestController
@RequestMapping("/store/store")
public class StoreController {
    @Autowired
    private StoreService storeService  = new StoreServiceImpl() {
        @PostMapping
        @ApiOperation(value = "创建商家")
        public ResponseResult creatStores(StoreVo storeVo) {
            return storeService.creatStores(storeVo);
        }

        @GetMapping
        @ApiOperation(value = "通过id查询商家")
        public ResponseResult queryStoresById(Integer userId, Integer storeId, Integer pageNum, Integer pageSize) {
            return storeService.queryStoresById(null, storeId, pageNum, pageSize);
        }

        @GetMapping
        @ApiOperation(value = "通过用户id查询商家")
        public ResponseResult queryStoresByUserId(Integer userId, Integer pageNum, Integer pageSize) {
            return storeService.queryStoresByUserId(userId, pageNum, pageSize);
        }
    };
}
