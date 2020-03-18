package com.myimooc.ssh.employee.domain;

import java.util.List;

/**
 * 分页功能实体对象
 *
 * @author zc 2017-08-18
 */
public class PageBean<T> {

    /**
     * 当前页
     */
    private int currPage;
    /**
     * 每页显示的记录数
     */
    private int pageSize;
    /**
     * 总记录数
     */
    private int totalCount;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 每页显示的数据
     */
    private List<T> list;

    @Override
    public String toString() {
        return "PageBean [currPage=" + currPage + ", pageSize=" + pageSize + ", totalCount=" + totalCount
                + ", totalPage=" + String.valueOf(totalPage) + ", list=" + list + "]";
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }


}
