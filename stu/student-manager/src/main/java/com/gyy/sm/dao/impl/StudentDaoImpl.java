package com.gyy.sm.dao.impl;

import com.gyy.sm.VO.StudentVo;
import com.gyy.sm.dao.StudentDao;
import com.gyy.sm.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StudentDaoImpl
 * @Description TODO
 * @Author GYY
 * @Date 2020/11/26
 **/
public class StudentDaoImpl implements StudentDao {
    @Override
    public List<StudentVo> selectAll() throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.*, t2.class_name, t3.department_name\n" +
                "FROM t_student t1\n" +
                "LEFT JOIN t_class t2\n" +
                "ON t1.class_id = t2.id\n" +
                "LEFT JOIN t_department t3\n" +
                "ON t2.department_id = t3.id";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
//        List<StudentVo> list = new ArrayList<>();
//        while (rs.next()) {
//            StudentVo student = StudentVo.builder()
//                    .id(rs.getString("id"))
//                    .departmentName(rs.getString("department_name"))
//                    .className((rs.getString("class_name")))
//                    .studentName(rs.getString("student_name"))
//                    .phone(rs.getString("phone"))
//                    .gender(rs.getShort("gender"))
//                    .avatar(rs.getString("avatar"))
//                    .birthday(rs.getDate("birthday"))
//                    .address(rs.getString("address"))
//                    .build();
//            list.add(student);
//        }
        List<StudentVo> list = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return list;
    }

    @Override
    public List<StudentVo> getAll() throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.*,t2.class_name,t3.department_name\n " +
                "from t_student as t1\n" +
                "left join t_class as t2\n" +
                "on t1.class_id = t2.id\n" +
                "left join t_department as t3\n" +
                "on t2.department_id = t3.id;";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<StudentVo> list = new ArrayList<>();
        while (rs.next()) {
            StudentVo student = StudentVo.builder()
                    .id(rs.getString("id"))
                    .departmentName(rs.getString("department_name"))
                    .className(rs.getString("class_name"))
                    .studentName(rs.getString("student_name"))
                    .phone(rs.getString("phone"))
                    .gender(rs.getShort("gender"))
                    .avatar(rs.getString("avatar"))
                    .birthday(rs.getDate("birthday"))
                    .address(rs.getString("address"))
                    .build();
            list.add(student);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return list;
    }

    @Override
    public List<StudentVo> selectByDepId(int depId) throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.*, t2.class_name, t3.department_name\n"+
                "FROM t_student t1\n"+
                "LEFT JOIN t_class t2\n"+
                "ON t1.class_id = t2.id \n"+
                "LEFT JOIN t_department t3 \n"+
                "ON t2.department_id = t3.id \n"+
                "WHERE t3.id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, depId);
        ResultSet rs = pstmt.executeQuery();
        List<StudentVo> list = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return list;
    }

    @Override
    public List<StudentVo> selectByClassId(int classId) throws  SQLException{
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.*, t2.class_name, t3.department_name\n"+
                "FROM t_student t1\n"+
                "LEFT JOIN t_class t2\n"+
                "ON t1.class_id = t2.id\n"+
                "LEFT JOIN t_department t3 \n"+
                "ON t2.department_id = t3.id \n"+
                "WHERE t1.class_id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, classId);
        ResultSet rs = pstmt.executeQuery();
        List<StudentVo> list = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return list;
    }

    @Override
    public List<StudentVo> selectByKeywords(String keywords) throws SQLException{
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.*, t2.class_name, t3.department_name\n"+
                "FROM t_student t1\n"+
                "LEFT JOIN t_class t2\n"+
                "ON t1.class_id = t2.id\n"+
                "LEFT JOIN t_department t3 \n"+
                "ON t2.department_id = t3.id \n"+
                "WHERE t1.student_name LIKE ? OR t1.address LIKE ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,"%" + keywords + "%");
        pstmt.setString(2,"%" + keywords + "%");
        ResultSet rs = pstmt.executeQuery();
        List<StudentVo> list = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return list;
    }

    private List<StudentVo> convert(ResultSet rs) throws SQLException{
        List<StudentVo> list = new ArrayList<>();
        while (rs.next()) {
            StudentVo student = StudentVo.builder()
                    .id(rs.getString("id"))
                    .departmentName(rs.getString("department_name"))
                    .className(rs.getString("class_name"))
                    .studentName(rs.getString("student_name"))
                    .phone(rs.getString("phone"))
                    .gender(rs.getShort("gender"))
                    .avatar(rs.getString("avatar"))
                    .birthday(rs.getDate("birthday"))
                    .address(rs.getString("address"))
                    .build();
            list.add(student);
        }
        return list;
    }
}
