package com.express.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.express.enums.ResultCode;
import com.express.exceptions.exception.OrderException;
import com.express.order.POJO.OrderVo;
import com.express.order.entity.Orders;
import com.express.order.mapper.OrdersMapper;
import com.express.order.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.express.utils.PageUtils;
import com.express.utils.ResponseResult;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzy
 * @since 2023-01-15 02:19:11
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    private OrdersMapper ordersMapper;
    @Override
    public ResponseResult createOrders(OrderVo orderVo) {
        Orders order = new Orders();
        BeanUtils.copyProperties(orderVo, order);
        order.setUserId(1);
        save(order);
        return ResponseResult.okResult(orderVo);
    }

    @Override
    public ResponseResult queryOrdersById(Integer userId, Integer orderId, Integer pageNum, Integer pageSize) {
        Orders order = getById(orderId);
        if(order == null) {
            throw new OrderException(ResultCode.ORDER_NOT_EXIST);
        }
        return ResponseResult.okResult(order);
    }

    @Override
    public ResponseResult queryOrdersByUserId(Integer userId, Integer pageNum, Integer pageSize) {
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        IPage<Orders> list = page(PageUtils.getPage(pageNum, pageSize, Orders.class), queryWrapper);
        return ResponseResult.okResult(list);
    }

    @Override
    public ResponseResult queryOrdersByStoreId(Integer storeId, Integer pageNum, Integer pageSize) {
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("store_id", storeId);
        IPage<Orders> list = page(PageUtils.getPage(pageNum, pageSize, Orders.class), queryWrapper);
        return ResponseResult.okResult(list);
    }

    @Override
    public ResponseResult cancelOrder(Integer id){
        Orders order = getById(id);
        if(removeById(id)){
            return ResponseResult.okResult();
        }
        return ResponseResult.errorResult(ResultCode.ORDER_NOT_EXIST);
    }

    //TODO:增加订单状态改变接口
    private Orders toOrderEntity(Object object){
        Orders orders = new Orders();
        BeanUtils.copyProperties(object, orders);
        return orders;
    }
}
