package com.example.isgpspring.dao;

import com.example.isgpspring.entity.PSysMenus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PSysMenusDao extends JpaRepository<PSysMenus, Integer> {
    List<PSysMenus> findAllByMenuParentId(Integer parentId);
}
