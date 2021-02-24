package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "p_sys_dept")
public class PSysDept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Integer deptId;
    @Column(name= "dept_name")
    private String deptName;
    @Column(name="dept_parent_id")
    private Integer deptParentId;
    @Column(name="dept_leader")
    private Integer deptLeader;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getDeptParentId() {
        return deptParentId;
    }

    public void setDeptParentId(Integer deptParentId) {
        this.deptParentId = deptParentId;
    }

    public Integer getDeptLeader() {
        return deptLeader;
    }

    public void setDeptLeader(Integer deptLeader) {
        this.deptLeader = deptLeader;
    }
}
