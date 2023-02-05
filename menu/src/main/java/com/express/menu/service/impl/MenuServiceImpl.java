package com.express.menu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.express.enums.ResultCode;
import com.express.menu.entity.Menu;
import com.express.menu.mapper.MenuMapper;
import com.express.menu.pojo.MenuVo;
import com.express.menu.service.MenuService;
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
 * @since 2023-01-15 02:16:01
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Override
    public ResponseResult creatMenus(MenuVo menuVo) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuVo, menu);
        save(menu);
        MenuVo vo = new MenuVo();
        BeanUtils.copyProperties(menu, vo);
        return ResponseResult.okResult(vo);
    }

    @Override
    public ResponseResult queryMenusById(Integer userId, Integer menuId, Integer pageNum, Integer pageSize) {
        Menu menu = getById(menuId);
        if(menu == null) {
            return ResponseResult.errorResult(ResultCode.MENU_NOT_EXIST);
        }
        return ResponseResult.okResult(menu);
    }

    @Override
    public ResponseResult queryMenusByStoreId(Integer storeId, Integer pageNum, Integer pageSize) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("store_id", storeId);
        IPage<Menu> list = page(PageUtils.getPage(pageNum, pageSize, Menu.class), queryWrapper);
        return ResponseResult.okResult(list);
    }
    @Override
    public ResponseResult queryMenuByName(String name, Integer pageNum, Integer pageSize){
        IPage page = PageUtils.getPage(pageNum, pageSize, Menu.class);
        page(page, new QueryWrapper<Menu>().like("name", name));
        PageUtils pages = new PageUtils(page);
        pages.setList(toMenuVoList(pages.getList()));
        return ResponseResult.okResult(pages);
    }


    @Override
    public ResponseResult deleteByMenuId(Integer id){
        if(removeById(id)){
            return ResponseResult.okResult();
        }
        return ResponseResult.errorResult(ResultCode.MENU_NOT_EXIST);
    }

    private MenuVo toMenuVo(Menu menu) {
        MenuVo menuVo = new MenuVo();
        BeanUtils.copyProperties(menu, menuVo);
        return menuVo;
    }

    private List<MenuVo> toMenuVoList(List<Menu> list) {
        List<MenuVo> result = new ArrayList<>();
        for(Menu i : list){
            result.add(toMenuVo(i));
        }
        return result;
    }
}
