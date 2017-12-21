package com.st.mall.model.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author bobo.
 * @date 12/13/2017
 * @email ruantianbo@163.com
 */
@Table(name="tb_product_tag")
public class ProductTag extends Domain{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String tagName;

    Date createTime;

    Date lastModifyTime;

    Integer productId;

    public ProductTag() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Integer getProduct() {
        return productId;
    }

    public void setProduct(Integer productId) {
        this.productId = productId;
    }
}
