package com.express.order.service.impl;

import com.express.order.POJO.OrderVo;
import com.express.order.entity.Orders;
import com.express.order.mapper.OrdersMapper;
import com.express.order.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.express.utils.ResponseResult;
import org.springframework.stereotype.Service;

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

    @Override
    public ResponseResult createOrders(OrderVo orderVo) {
        return null;
    }

    @Override
    public ResponseResult queryOrdersById(Integer userId, Integer orderId, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public ResponseResult queryOrdersByUserId(Integer userId, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public ResponseResult queryOrdersByStoreId(Integer storeId, Integer pageNum, Integer pageSize) {
        return null;
    }
}
