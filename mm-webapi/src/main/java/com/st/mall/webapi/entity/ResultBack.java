package com.st.mall.webapi.entity;

/**
 * @author bobo.
 * @date 12/25/2017
 * @email ruantianbo@163.com
 */
public class ResultBack {
    private String code;
    private String msg;
    private Object backData;

    public ResultBack() {
    }

    public ResultBack(String code, String msg, Object backData) {
        this.code = code;
        this.msg = msg;
        this.backData = backData;
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

    public Object getBackData() {
        return backData;
    }

    public void setBackData(Object backData) {
        this.backData = backData;
    }
}
