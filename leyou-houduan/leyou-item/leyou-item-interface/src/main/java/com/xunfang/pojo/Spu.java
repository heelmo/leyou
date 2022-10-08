package com.xunfang.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Table(name = "tb_spu")
public class Spu {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long brandId;
    private Long cid1;             // 1级分类
    private Long cid2;             // 2级分类
    private Long cid3;             // 3级分类
    private String title;          // 标题
    private String subTitle;       // 子标题
    @JsonIgnore //判断是否上架转成json格式
    private Boolean saleable;      // 是否上架
    private Boolean valid;         // 是否有效
    @JsonIgnore //因为根据时间排序需要转为json格式
    private Date createTime;       // 创建时间
    private Date lastUpdateTime;   // 最后修改时间
    //数据库存放的是对应的id，最终要转化成名称
    //在页面中做辅助作用，但是在数据库表中不起作用
    @Transient //该属性在表中不存在，但操作要用
    private String cname;
    @Transient
    private String bname;
    //spu中有多个spu对象  但是该属性不属于表的字段
    @Transient
    private SpuDetail spuDetail;
    //spu中有多个sku对象  但是该属性不属于表的字段
    @Transient
    private List<Sku> skus;

    public SpuDetail getSpuDetail() {
        return spuDetail;
    }

    public void setSpuDetail(SpuDetail spuDetail) {
        this.spuDetail = spuDetail;
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }

    public Spu() {
    }

    public Spu(Long id, Long brandId, Long cid1, Long cid2, Long cid3, String title, String subTitle, Boolean saleable, Boolean valid, Date createTime, Date lastUpdateTime, String cname, String bname) {
        this.id = id;
        this.brandId = brandId;
        this.cid1 = cid1;
        this.cid2 = cid2;
        this.cid3 = cid3;
        this.title = title;
        this.subTitle = subTitle;
        this.saleable = saleable;
        this.valid = valid;
        this.createTime = createTime;
        this.lastUpdateTime = lastUpdateTime;
        this.cname = cname;
        this.bname = bname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCid1() {
        return cid1;
    }

    public void setCid1(Long cid1) {
        this.cid1 = cid1;
    }

    public Long getCid2() {
        return cid2;
    }

    public void setCid2(Long cid2) {
        this.cid2 = cid2;
    }

    public Long getCid3() {
        return cid3;
    }

    public void setCid3(Long cid3) {
        this.cid3 = cid3;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Boolean getSaleable() {
        return saleable;
    }

    public void setSaleable(Boolean saleable) {
        this.saleable = saleable;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }
}