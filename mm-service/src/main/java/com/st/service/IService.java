package com.st.service;

import com.st.dao.base.IMapper;

/**
 * @author Sanmu.
 * @date 11/26/2017
 * @email 1215148017@qq.com
 */
public interface IService<T> extends ISelectService<T> {

    IMapper<T> getIMapper();

}
