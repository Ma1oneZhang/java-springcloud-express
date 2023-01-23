package com.express.menu.service.impl;

import com.express.menu.entity.Menu;
import com.express.menu.mapper.MenuMapper;
import com.express.menu.pojo.MenuVo;
import com.express.menu.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.express.utils.ResponseResult;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzy
 * @since 2023-01-15 02:16:01
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Override
    public ResponseResult creatMenus(MenuVo menuVo) {
        return null;
    }

    @Override
    public ResponseResult queryMenusById(Integer userId, Integer menuId, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public ResponseResult queryMenusByStoreId(Integer storeId, Integer pageNum, Integer pageSize) {
        return null;
    }
}
