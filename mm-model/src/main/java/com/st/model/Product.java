package com.st.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author bobo.
 * @date 12/13/2017
 * @email ruantianbo@163.com
 */
@Table(name="tb_product")
public class Product {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String title;
    double price;
    String content;
    //淘宝联盟
    Boolean isTaoBao;
    //淘宝链接
    String link;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getTaoBao() {
        return isTaoBao;
    }

    public void setTaoBao(Boolean taoBao) {
        isTaoBao = taoBao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


}
