package com.express.order.controller;

import com.express.order.POJO.OrderVo;
import com.express.order.entity.Orders;
import com.express.order.service.OrdersService;
import com.express.order.service.impl.OrdersServiceImpl;
import com.express.utils.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzy
 * @since 2023-01-15 02:19:11
 */
@RestController
@RequestMapping("/order")
public class OrdersController {
    // TODO
    @Autowired
    private OrdersService ordersService = new OrdersServiceImpl();

    @PostMapping("/create")
    @ApiOperation(value = "创建订单")
    ResponseResult<OrderVo> createOrders(@RequestBody OrderVo orderVo){
        return ordersService.createOrders(orderVo);
    }

    @GetMapping("/querybyid")
    @ApiOperation(value = "查询订单")
    ResponseResult<OrderVo> queryOrdersById(Integer id, Integer pageNum, Integer pageSize){
        // TODO: 鉴权的同时获取用户信息
        return ordersService.queryOrdersById(null, id, pageNum, pageSize);
    }

    @GetMapping("/querybyuser")
    @ApiOperation(value = "用户查询个人订单")
    ResponseResult<OrderVo> queryOrdersByUserId(Integer userId, Integer pageNum, Integer pageSize){
        // TODO: 鉴权的同时获取用户信息
        return ordersService.queryOrdersByUserId(userId, pageNum, pageSize);
    }

    @GetMapping("/querybystore")
    @ApiOperation(value = "商户查询商家订单情况")
    ResponseResult<OrderVo> queryOrdersByStoreId(Integer storeId, Integer pageNum, Integer pageSize){
        // TODO: 鉴权的同时获取用户信息
        return ordersService.queryOrdersByStoreId(storeId , pageNum, pageSize);
    }

    @GetMapping("/cancelorder")
    @ApiOperation(value = "删除订单")
    ResponseResult<OrderVo> cancelOrder(Integer id){
        // TODO: 鉴权的同时获取用户信息
        return ordersService.cancelOrder(id);
    }
}
