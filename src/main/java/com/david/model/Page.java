package com.david.model;

/**
 * 首页微博分页模型
 */
public class Page {
    public static final int WEIBOS_SHOWN_PER_PAGE = 5;
    private int totalPage;
    private int pageNow;
    private int totalWeibos;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getTotalWeibos() {
        return totalWeibos;
    }

    public void setTotalWeibos(int totalWeibos) {
        this.totalWeibos = totalWeibos;
    }
}
