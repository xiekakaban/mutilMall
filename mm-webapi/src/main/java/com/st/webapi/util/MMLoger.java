package com.st.webapi.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tk.mybatis.mapper.util.StringUtil;

/**
 * @author bobo.
 * @date 12/6/2017
 * @email ruantianbo@163.com
 */
public class MMLoger{
    private Logger logger;

    private MMLoger(String name){
        logger = LoggerFactory.getLogger(name);
    }

    public static MMLoger getLogger(Class<?> type) {
        return new MMLoger(type.getSimpleName());
    }

    public static MMLoger getLogger(String name){
        return new MMLoger(name);
    }

    public void trace(String msgStyle,String... msg){
        if(logger.isTraceEnabled()) {
            logger.trace(format(msgStyle,msg));
        }
    }

    public void trace(Throwable throwable,String msgStyle,String... msg){
        if(logger.isTraceEnabled()) {
            logger.trace(format(msgStyle,msg),throwable);
        }
    }

    public void warn(String msgStyle,String... msg){
        if(logger.isWarnEnabled()){
            logger.warn(format(msgStyle,msg));
        }
    }

    public void warn(Throwable throwable,String msgStyle,String... msg){
        if(logger.isWarnEnabled()) {
            logger.warn(format(msgStyle,msg),throwable);
        }
    }

    public void info(String msgStyle,String... msg){
        if(logger.isInfoEnabled()) {
            logger.info(format(msgStyle, msg));
        }
    }
    public void info(Throwable throwable,String msgStyle,String... msg){
        if(logger.isInfoEnabled()) {
            logger.info(format(msgStyle, msg),throwable);
        }
    }

    public void error(String msgStyle,String... msg){
        if(logger.isErrorEnabled()) {
            logger.error(format(msgStyle,msg));
        }
    }

    public void error(Throwable throwable,String msgStyle,String... msg){
        if(logger.isErrorEnabled()) {
            logger.error(format(msgStyle,msg),throwable);
        }
    }

    private String format(String style, String... params) {
        if (StringUtil.isNotEmpty(style) && params.length > 0) {
            return String.format((String)style, params);
        }
        return style;
    }

}
