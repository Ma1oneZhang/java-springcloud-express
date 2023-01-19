package com.express.order.service;

import com.express.order.POJO.OrderVo;
import com.express.order.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.express.utils.ResponseResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzy
 * @since 2023-01-15 02:19:11
 */
public interface OrdersService extends IService<Orders> {

    /**
     * 创建订单
     *
     * @author zzy
     * @param orderVo orderVo
     * @return 返回订单详细信息
     * */
    ResponseResult createOrders(OrderVo orderVo);

    /**
     * 通过id查询订单
     *
     * @author zzy
     * @param orderId order_id
     * @param userId user_id
     * @param pageSize pageSize
     * @param pageNum pageNum
     * @return 返回订单详细信息
     * */
    ResponseResult queryOrdersById(Integer userId,Integer orderId, Integer pageNum, Integer pageSize);

    /**
     * 通过用户id查询订单
     *
     * @author zzy
     * @param userId user_id
     * @param pageSize pageSize
     * @param pageNum pageNum
     * @return 返回订单详细信息
     * */
    ResponseResult queryOrdersByUserId(Integer userId, Integer pageNum, Integer pageSize);


    /**
     * 商家查询订单情况
     *
     * @author zzy
     * @param storeId store_id
     * @param pageSize pageSize
     * @param pageNum pageNum
     * @return 返回订单详细信息
     * */
    ResponseResult queryOrdersByStoreId(Integer storeId, Integer pageNum, Integer pageSize);
}
