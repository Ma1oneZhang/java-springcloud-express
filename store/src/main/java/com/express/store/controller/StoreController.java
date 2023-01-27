package com.express.store.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.express.store.pojo.StoreVo;
import com.express.store.service.StoreService;
import com.express.store.service.impl.StoreServiceImpl;
import com.express.utils.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        @ApiOperation(value = "创建商店")
        public ResponseResult<StoreVo> createStores(StoreVo storeVo) {
            return storeService.createStores(storeVo, null);
        }

        @GetMapping
        @ApiOperation(value = "通过商店id查询商店")
        public ResponseResult<StoreVo> queryStoresByStoreId(Integer storeId) {
            return storeService.queryStoresByStoreId(storeId);
        }

        // TODO:
        // using spring security to get user id
        @GetMapping
        @ApiOperation(value = "通过用户id查询商店")
        public ResponseResult<IPage<StoreVo>> queryStoresByUserId(Integer pageNum, Integer pageSize) {
            return storeService.queryStoresByUserId(null, pageNum, pageSize);
        }

        @GetMapping
        @ApiOperation(value = "通过名字搜索商店")
        public ResponseResult<IPage<StoreVo>> queryStoresByStoreName(String name, Integer pageNum, Integer pageSize){
            return storeService.queryStoresByName(name, pageNum, pageSize);
        }
    };
}
