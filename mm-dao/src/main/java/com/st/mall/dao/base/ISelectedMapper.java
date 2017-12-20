package com.st.mall.dao.base;

import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.base.BaseSelectMapper;
import tk.mybatis.mapper.common.base.select.SelectAllMapper;
import tk.mybatis.mapper.common.example.SelectByExampleMapper;
import tk.mybatis.mapper.common.example.SelectCountByExampleMapper;
import tk.mybatis.mapper.common.rowbounds.SelectByExampleRowBoundsMapper;
import tk.mybatis.mapper.common.rowbounds.SelectRowBoundsMapper;

/**
 * @author Sanmu.
 * @date 11/26/2017
 * @email 1215148017@qq.com
 */
public interface ISelectedMapper<T> extends Marker,
        BaseSelectMapper<T>,
        SelectByExampleMapper<T>,
        SelectCountByExampleMapper<T>,
        SelectByExampleRowBoundsMapper<T>,
        SelectRowBoundsMapper<T>,
        SelectAllMapper<T> {
}
