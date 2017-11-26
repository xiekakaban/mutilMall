package com.st.dao.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author Sanmu.
 * @date 11/26/2017
 * @email 1215148017@qq.com
 */
public interface IMapper<T> extends
        Mapper<T>,
        MySqlMapper<T>,
        ISelectedMapper<T> {
}
