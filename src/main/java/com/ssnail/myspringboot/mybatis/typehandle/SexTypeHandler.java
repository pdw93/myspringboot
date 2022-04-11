package com.ssnail.myspringboot.mybatis.typehandle;

import com.ssnail.myspringboot.domain.model.enums.SexEnum;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

/**
 * @author pengdengwang
 * @since 2021/8/7
 */
// 声明 JdbcType 为整形
@MappedJdbcTypes(JdbcType.INTEGER)
// 声明 JavaType 为 SexEnum
@MappedTypes(value = SexEnum.class)
public class SexTypeHandler extends BaseTypeHandler<SexEnum> {
    // 设置非空参数
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, sexEnum.getSex());
    }

    // 通过列名读取
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int sexInt = resultSet.getInt(s);
        return SexEnum.getSexEnum(sexInt);
    }

    // 通过下标读取
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int sexInt = resultSet.getInt(i);
        return SexEnum.getSexEnum(sexInt);
    }

    // 通过存储过程读取性别
    @Override
    public SexEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int sexInt = callableStatement.getInt(i);
        return SexEnum.getSexEnum(sexInt);
    }
}
