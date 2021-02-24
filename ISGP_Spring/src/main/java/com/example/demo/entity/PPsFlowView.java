package com.example.demo.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="p_ps_flow_view")
public class PPsFlowView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flow_id")
    private Integer flowId;
    @Column(name = "flow_name")
    private String flowName;
    @Column(name = "flow_content")
    private String flowContent;
    @Column(name="flow_state")
    private Short flowState;
    @Column(name="modified_by_user")
    private String modifiedUser;
    @Column(name="modified_date")
    private Date modifiedDate;

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public String getFlowContent() {
        return flowContent;
    }

    public void setFlowContent(String flowContent) {
        this.flowContent = flowContent;
    }

    public Short getFlowState() {
        return flowState;
    }

    public void setFlowState(Short flowState) {
        this.flowState = flowState;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }


}
