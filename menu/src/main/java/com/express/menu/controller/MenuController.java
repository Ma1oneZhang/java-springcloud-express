package com.express.menu.controller;

import com.express.menu.entity.Menu;
import com.express.menu.pojo.MenuVo;
import com.express.menu.service.MenuService;
import com.express.menu.service.impl.MenuServiceImpl;
import com.express.utils.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzy gqc
 * @since 2023-01-15 02:16:01
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService  = new MenuServiceImpl();

    @PostMapping("/create")
    @ApiOperation(value = "创建菜品")
        ResponseResult<MenuVo> creatMenus(@RequestBody MenuVo menuVo) {return menuService.creatMenus(menuVo);}

    @GetMapping("/querybyid")
    @ApiOperation(value = "通过id查询菜品")
    ResponseResult<MenuVo> queryMenusById(Integer id, Integer pageNum, Integer pageSize){
        return menuService.queryMenusById(null, id, pageNum, pageSize);
    }

    @GetMapping("/querybystore")
    @ApiOperation(value = "通过商家id查询菜品")
    ResponseResult<MenuVo> queryMenusByStoreId(Integer id, Integer pageNum, Integer pageSize){
        return menuService.queryMenusByStoreId(id, pageNum, pageSize);
    }
    @GetMapping("/querybyname")
    @ApiOperation(value = "通过菜品名称模糊搜索")
    ResponseResult<MenuVo> queryMenuByName(String name, Integer pageNum, Integer pageSize){
        return menuService.queryMenuByName(name, pageNum, pageSize);
    }

    @GetMapping("/deletebyid")
    @ApiOperation(value = "通过主键删除菜品")
    ResponseResult<MenuVo> deleteByMenuId(Integer id){
        return menuService.deleteByMenuId(id);
    }
}
