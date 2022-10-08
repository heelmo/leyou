package com.xunfang.common.pojo;

import java.util.List;

/*
* total
* List<T>

* */
public class PageUtils <T>{
    private Integer total;
    private List<T> items;

    public PageUtils(Integer total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
