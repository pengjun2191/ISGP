package com.example.demo.util;

import com.example.demo.pojo.PageInfo;
import org.springframework.data.domain.Page;

import java.util.List;

public class JpaPageUtil {
    public static <E> PageInfo<E> queryPage(Page<E> page,String operlogs)
    {
        return new PageInfo<>(page.getContent(),operlogs,page.getTotalElements(),page.getNumber()+1,page.getSize(),page.getNumberOfElements());
    }
    public static <E> PageInfo<E> queryPage(List<E> page,String operlogs)
    {
        return new PageInfo<>(page,operlogs,(long) page.size());
    }
}
