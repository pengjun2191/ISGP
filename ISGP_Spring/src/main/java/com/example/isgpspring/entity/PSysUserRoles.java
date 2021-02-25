package com.example.isgpspring.entity;


import javax.persistence.*;
@Entity
@Table(name="p_sys_user_roles")
public class PSysUserRoles {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ur_id")
  private Integer urId;
  @Column(name="user_id")
  private Integer userId;
  @Column(name="role_id")
  private Integer roleId;


  public Integer getUrId() {
    return urId;
  }

  public void setUrId(Integer urId) {
    this.urId = urId;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

}
