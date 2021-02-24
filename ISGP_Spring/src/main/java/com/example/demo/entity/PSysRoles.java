package com.example.demo.entity;

import javax.persistence.*;
@Entity
@Table(name="p_sys_roles")
public class PSysRoles {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="role_id")
  private Integer roleId;
  @Column(name="role_name_es")
  private String roleNameEs;
  @Column(name="role_name_zh")
  private String roleNameZh;


  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }


  public String getRoleNameEs() {
    return roleNameEs;
  }

  public void setRoleNameEs(String roleNameEs) {
    this.roleNameEs = roleNameEs;
  }


  public String getRoleNameZh() {
    return roleNameZh;
  }

  public void setRoleNameZh(String roleNameZh) {
    this.roleNameZh = roleNameZh;
  }

}
