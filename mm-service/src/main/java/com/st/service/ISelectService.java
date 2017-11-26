package com.st.service;

import com.st.dao.base.ISelectedMapper;

/**
 * @author Sanmu.
 * @date 11/26/2017
 * @email 1215148017@qq.com
 */
public interface ISelectService<T> {

    ISelectedMapper<T> getIMapper();

}
