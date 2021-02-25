package com.example.isgpspring.pojo;

import java.io.Serializable;
import java.util.List;

public class PageInfo<T> implements Serializable {
    //{"dataList":[{},{}],
    // "operLogs":null,
    // "totalNum":436,
    // "pageNum":1,
    // "pageSize":10,
    // "totalPage":44,
    // "currentPageSize":10}
    private static final long serialVersionUID = 1L;
    private List<T> datalist;//记录
    private String operLogs;//操作日志
    private Long totalnum;//记录总数
    private Integer pageNum;//分页号
    private Integer pageSize;//分页计划数
    private Integer currentPageSize;//分页实际数


    public PageInfo(Long totalnum) {
        this.totalnum = totalnum;
    }

    public PageInfo(List<T> datalist, Long totalnum) {
        this.datalist = datalist;
        this.totalnum = totalnum;
    }

    public PageInfo(List<T> datalist, String operLogs, Long totalnum) {
        this.datalist = datalist;
        this.operLogs = operLogs;
        this.totalnum = totalnum;
    }

    public PageInfo(List<T> datalist, String operLogs, Long totalnum, Integer pageNum, Integer pageSize, Integer currentPageSize) {
        this.datalist = datalist;
        this.operLogs = operLogs;
        this.totalnum = totalnum;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.currentPageSize = currentPageSize;
    }

    public List<T> getDatalist() {
        return datalist;
    }

    public void setDatalist(List<T> datalist) {
        this.datalist = datalist;
    }

    public String getOperLogs() {
        return operLogs;
    }

    public void setOperLogs(String operLogs) {
        this.operLogs = operLogs;
    }

    public Long getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(Long totalnum) {
        this.totalnum = totalnum;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPageSize() {
        return currentPageSize;
    }

    public void setCurrentPageSize(Integer currentPageSize) {
        this.currentPageSize = currentPageSize;
    }
}
