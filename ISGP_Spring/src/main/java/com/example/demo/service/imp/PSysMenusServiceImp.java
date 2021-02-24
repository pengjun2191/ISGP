package com.example.demo.service.imp;


import com.example.demo.dao.PSysMenusDao;
import com.example.demo.entity.PSysMenus;
import com.example.demo.pojo.PageInfo;
import com.example.demo.service.IPSysMenusService;
import com.example.demo.util.JpaPageUtil;
import com.example.demo.util.OtherUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PSysMenusServiceImp implements IPSysMenusService {
    @Autowired
    PSysMenusDao pSysMenusDao;

    OtherUtils otherUtils;
    public List<PSysMenus> getAllByParentId(Integer parentId){ return pSysMenusDao.findAllByMenuParentId(parentId); }

    public void handleMenus(List<PSysMenus> menus) {
        menus.forEach(m -> {
            List<PSysMenus> children = getAllByParentId(m.getMenuId());
            m.setChildren(children);
        });
        menus.removeIf(m -> m.getMenuParentId() != 0);
    }

    @Override
    public PageInfo<PSysMenus> getMenusAll(Integer pageNum, Integer pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC, "menuId");
        Page<PSysMenus> menuPage = pSysMenusDao.findAll(PageRequest.of(otherUtils.toPageNum(pageNum), pageSize, sort));
        return JpaPageUtil.queryPage(menuPage,"查询menus成功");
    }

    @Override
    public PageInfo<PSysMenus> getAll() {
        return JpaPageUtil.queryPage(pSysMenusDao.findAll(),"查询menus成功");
    }
}
