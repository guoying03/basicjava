package com.gyy.sm.dao.impl;

import com.gyy.sm.dao.ClazzDao;
import com.gyy.sm.entity.Clazz;
import com.gyy.sm.utils.JdbcUtil;
import com.gyy.sm.utils.ResultEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ClazzDaoImpl
 * @Description TODO
 * @Author GYY
 * @Date 2020/11/23
 **/
public class ClazzDaoImpl implements ClazzDao {
    @Override
    public  List<Clazz> selectByDepartmentId(int departmentId) throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM t_class WHERE department_id = ? ORDER BY id desc";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, departmentId);
        ResultSet rs = pstmt.executeQuery();
        List<Clazz> list = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return list;
    }

    @Override
    public List<Clazz> selectAll() throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM t_class OEDER BY id desc";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Clazz> list = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return list;
    }

    private List<Clazz> convert(ResultSet rs) throws SQLException{
        List<Clazz> clazzList = new ArrayList<>();
        while (rs.next()){
            Clazz clazz = new Clazz();
            clazz.setId(rs.getInt(("id")));
            clazz.setDepartmentId(rs.getInt(("department_id")));
            clazz.setClassName(rs.getString(("class_name")));
            clazzList.add(clazz);
        }
        return  clazzList;
    }
    @Override
    public int insertClazz(Clazz clazz) throws SQLException{
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "INSERT INTO t_class (department_id,class_name) VALUES (?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1,clazz.getDepartmentId());
        pstmt.setString(2,clazz.getClassName());
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }
    @Override
    public int deleteClazz(Integer id) throws SQLException{
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "DELETE FROM t_class WHERE id = "+id;
        PreparedStatement pstmt = connection.prepareStatement(sql);
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }
}
