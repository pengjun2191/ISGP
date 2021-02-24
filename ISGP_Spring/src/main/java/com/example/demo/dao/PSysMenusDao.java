package com.example.demo.dao;

import com.example.demo.entity.PSysMenus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PSysMenusDao extends JpaRepository<PSysMenus, Integer> {
    List<PSysMenus> findAllByMenuParentId(Integer parentId);
}
