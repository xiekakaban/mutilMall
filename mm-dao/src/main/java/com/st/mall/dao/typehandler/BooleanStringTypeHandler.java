package com.st.mall.dao.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author bobo.
 * @date 12/19/2017
 * @email ruantianbo@163.com
 */
@MappedTypes(Boolean.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class BooleanStringTypeHandler implements TypeHandler{
    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        Boolean b = (Boolean)parameter;
        ps.setString(i,b ? "N":"Y");
    }

    @Override
    public Object getResult(ResultSet rs, String columnName) throws SQLException {
        return (rs.getString(columnName).equalsIgnoreCase("Y")?Boolean.TRUE:Boolean.FALSE);
    }

    @Override
    public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
        return (rs.getString(columnIndex).equalsIgnoreCase("Y")?Boolean.TRUE:Boolean.FALSE);
    }

    @Override
    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return (cs.getString(columnIndex).equalsIgnoreCase("Y")?Boolean.TRUE:Boolean.FALSE);
    }
}
