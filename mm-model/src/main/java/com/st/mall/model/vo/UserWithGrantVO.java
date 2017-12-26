package com.st.mall.model.vo;

import com.st.mall.model.entity.User;

import java.util.List;

/**
 * @author bobo.
 * @date 12/26/2017
 * @email ruantianbo@163.com
 */
public class UserWithGrantVO extends User{
    List<String> roles;

    public UserWithGrantVO() {

    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
