package com.example.demo.util;

import com.example.demo.pojo.PageInfo;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;


public class MybatisPageUtil {

    /**
     * 分页查询
     *
     * @param pageNum  从1开始,传0会全部查询不分页
     * @param pageSize 分页size
     * @param select
     * @return
     */
/*    public static <E> Page<E> startPage(int pageNum, int pageSize, IDaoCrud select) {
        com.github.pagehelper.Page<E> page = PageHelper.startPage(pageNum, pageSize).doSelectPage(select);
        return new Page<>(page.getResult(),page.getTotal());
    }*/
    public static <E> PageInfo<E> queryPage(int pageNum, int pageSize, IDaoCrud select) {
        com.github.pagehelper.Page<E> page = PageHelper.startPage(pageNum, pageSize).doSelectPage(select);
        return new PageInfo<>(page.getResult(),"分页查询成功",page.getTotal(),page.getPageNum(),page.getPageSize(),page.getEndRow());
    }

    public interface IDaoCrud extends ISelect {

    }
}
