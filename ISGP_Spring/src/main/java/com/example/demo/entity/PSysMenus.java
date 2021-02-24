package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

/*
 *
 * @param null
 * @return
 * @author P_Jun
 * @date 2020/12/4 14:38
 */
@Entity
@Table(name="p_sys_menu")
public class PSysMenus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="menu_id")
    private Integer menuId;
    @Column(name="menu_name_es")
    private String menuNameES;
    @Column(name="menu_name_zh")
    private String menuNameZH;
    @Column(name="menu_path")
    private String menuPath;
    @Column(name="menu_icon")
    private String menuIcon;
    @Column(name="menu_component")
    private String menuComponent;
    @Column(name="menu_parent_id")
    private Integer menuParentId;
    @Column(name="menu_status")
    private Short menuStatus;
    @Transient
    private List<PSysMenus> children;

    public List<PSysMenus> getChildren() {
        return children;
    }

    public void setChildren(List<PSysMenus> children) {
        this.children = children;
    }
    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuNameES() {
        return menuNameES;
    }

    public void setMenuNameES(String menuNameES) {
        this.menuNameES = menuNameES;
    }

    public String getMenuNameZH() {
        return menuNameZH;
    }

    public void setMenuNameZH(String menuNameZH) {
        this.menuNameZH = menuNameZH;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuComponent() {
        return menuComponent;
    }

    public void setMenuComponent(String menuComponent) {
        this.menuComponent = menuComponent;
    }

    public Integer getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
    }

    public Short getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(Short menuStatus) {
        this.menuStatus = menuStatus;
    }
}
