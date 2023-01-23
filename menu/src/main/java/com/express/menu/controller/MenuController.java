package com.express.menu.controller;

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
@RequestMapping("/menu/menu")
public class MenuController {
    @Autowired
    private MenuService menuService  = new MenuServiceImpl();

    @PostMapping
    @ApiOperation(value = "创建菜品")
    ResponseResult creatMenus(@RequestBody MenuVo menuVo) {return menuService.creatMenus(menuVo);}

    @GetMapping
    @ApiOperation(value = "通过id查询菜品")
    ResponseResult queryMenusById(Integer id, Integer pageNum, Integer pageSize){
        return menuService.queryMenusById(null, id, pageNum, pageSize);
    }

    @GetMapping
    @ApiOperation(value = "通过商家id查询菜品")
    ResponseResult queryMenusByStoreId(Integer id, Integer pageNum, Integer pageSize){
        return menuService.queryMenusByStoreId(id, pageNum, pageSize);
    }

}
