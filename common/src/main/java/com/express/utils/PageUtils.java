package com.express.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.express.enums.ResultCode;
import com.express.exceptions.exception.SystemException;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
public class PageUtils<T> {

    private static final long serialVersionUID = 1L;
    /**
     * 总记录数
     */
    private int totalCount;
    /**
     * 每页记录数
     */
    private int pageSize;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 当前页数
     */
    private int currPage;
    /**
     * 列表数据
     */
    private List<T> list;

    /**
     * @Title: getPage
     * @Description: 省去判空
     * @Author: zhenyu
     * @DateTime: 2022/8/29 12:21
     * @param pageNum
     * @param pageSize
     * @param clazz
     * @return com.baomidou.mybatisplus.core.metadata.IPage<T>
     */
    public static <T> IPage<T> getPage(Integer pageNum, Integer pageSize, Class<T> clazz) {
        if (Objects.isNull(pageNum) || Objects.isNull(pageSize) || pageNum.equals(0) || pageSize.equals(0)) {
            throw new SystemException(ResultCode.PAGE_BLANK_OR_ZERO);
        }
        IPage<T> EntityPage = new Page<>(pageNum, pageSize);
        return EntityPage;
    }

    /**
     * 分页
     * @param list        列表数据
     * @param totalCount  总记录数
     * @param pageSize    每页记录数
     * @param currPage    当前页数
     */
    public PageUtils(List<T> list, int totalCount, int pageSize, int currPage) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.totalPage = (int)Math.ceil((double)totalCount/pageSize);
    }

    /**
     * 分页
     */
    public PageUtils(IPage<T> page) {
        this.list = page.getRecords();
        this.totalCount = (int)page.getTotal();
        this.pageSize = (int)page.getSize();
        this.currPage = (int)page.getCurrent();
        this.totalPage = (int)page.getPages();
    }
}
