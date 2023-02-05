package com.express.menu.service;

import com.express.MenuApplication;
import com.express.menu.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.express.menu.pojo.MenuVo;
import com.express.utils.ResponseResult;
import org.springframework.boot.SpringApplication;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzy
 * @since 2023-01-15 02:16:01
 */
public interface MenuService extends IService<Menu> {
    /**
     * 创建菜品
     * @author gqc
     * @param menuVo menuVo
     * @return 返回菜品详细信息
     */
    ResponseResult<Menu> creatMenus(MenuVo menuVo);

    /**
     * 通过id查询菜品
     * @author gqc
     * @param menuId menu_id
     * @param userId user_id
     * @param pageSize pageSize
     * @param pageNum pageNum
     * @return 返回菜品详细信息
     *
     */

    ResponseResult<Menu> queryMenusById(Integer userId, Integer menuId, Integer pageNum, Integer pageSize);
    /**
     * 通过商家id查询菜品
     * @author gqc
     * @param storeId store_id
     * @param pageSize pageSize
     * @param pageNum pageNum
     * @return 返回菜品详细信息
     *
     */

    ResponseResult<Menu> queryMenusByStoreId(Integer storeId, Integer pageNum, Integer pageSize);

    /**
     * 通过菜品名称模糊搜索
     * @author gqc
     * @param name name
     * @param pageSize pageSize
     * @param pageNum pageNum
     * @return 返回菜品详细信息
     *
     */
    ResponseResult<Menu> queryMenuByName(String name, Integer pageNum, Integer pageSize);

    /**
     * 删除菜品
     * @author gqc
     * @param id id
     * @return 返回菜品详细信息
     *
     */
    ResponseResult<Menu> deleteByMenuId(Integer id);
}
