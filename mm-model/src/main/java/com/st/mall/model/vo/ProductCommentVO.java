package com.st.mall.model.vo;

import com.st.mall.model.entity.ProductComment;
import com.st.mall.model.entity.User;

import java.util.Date;

/**
 * @author bobo.
 * @date 12/25/2017
 * @email ruantianbo@163.com
 */
public class ProductCommentVO {
    Integer id;

    Integer productId;
    User user;
    String commentContent;
    Date commentTime;
    Integer replyTo;

    public ProductCommentVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

     public Integer getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(Integer replyTo) {
        this.replyTo = replyTo;
    }
}
