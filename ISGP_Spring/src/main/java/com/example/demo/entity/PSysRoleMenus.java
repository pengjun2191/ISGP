package com.example.demo.entity;


import javax.persistence.*;
@Entity
@Table(name="p_sys_role_menus")
public class PSysRoleMenus {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="rm_id")
  private Integer rmId;
  @Column(name="role_id")
  private Integer roleId;
  @Column(name="menu_id")
  private Integer menuId;


  public Integer getRmId() {
    return rmId;
  }

  public void setRmId(Integer rmId) {
    this.rmId = rmId;
  }


  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }


  public Integer getMenuId() {
    return menuId;
  }

  public void setMenuId(Integer menuId) {
    this.menuId = menuId;
  }

}
