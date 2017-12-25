package com.st.mall.webapi.util;

import com.st.mall.webapi.entity.ResultBack;
import com.st.mall.webapi.enums.ResultBackCodeEnum;

/**
 * @author bobo.
 * @date 12/25/2017
 * @email ruantianbo@163.com
 */
public class ResultBackUtil {
    public static ResultBack success(Object o){
        return new ResultBack(ResultBackCodeEnum.STATE_OK.getCode(),ResultBackCodeEnum.STATE_OK.getMsg(),o);
    }

    public static ResultBack success(){
        return new ResultBack(ResultBackCodeEnum.STATE_OK.getCode(),ResultBackCodeEnum.STATE_OK.getMsg(),"");
    }


    public static ResultBack error(ResultBackCodeEnum resultBackCodeEnum){
        return new ResultBack(resultBackCodeEnum.getCode(),resultBackCodeEnum.getMsg(),"");
    }
}
