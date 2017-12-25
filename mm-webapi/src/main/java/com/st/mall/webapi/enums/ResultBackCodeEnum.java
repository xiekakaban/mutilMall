package com.st.mall.webapi.enums;

/**
 * @author bobo.
 * @date 12/25/2017
 * @email ruantianbo@163.com
 */
public enum ResultBackCodeEnum {
    STATE_OK("200","调用成功"),
    AUTHOR_ERROR("50","请先登陆"),
    PARAM_ERROR("51","请检查你输入都参数"),
    UNKNOWN_ERROR("99","未知错误")
    ;

    private String code;
    private String msg;

    ResultBackCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
