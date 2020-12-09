package com.gyy.sm.dao;

import com.gyy.sm.VO.StudentVo;
import com.gyy.sm.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoTest {

    @Test
    public void selectAll() throws SQLException {
        List<StudentVo> list = DaoFactory.getStudentDaoInstance().selectAll();
        list.forEach(System.out ::println);
    }


    @Test
    public void selectByDepId() throws SQLException{
        List<StudentVo> list = DaoFactory.getStudentDaoInstance().selectByDepId(5);
        list.forEach(System.out::println);
    }

    @Test
    public void selectByClassId() throws SQLException{
        List<StudentVo> list = DaoFactory.getStudentDaoInstance().selectByClassId(18);
        list.forEach(System.out::println);
    }

    @Test
    public void selectByKeywords() throws SQLException{
        List<StudentVo> list = DaoFactory.getStudentDaoInstance().selectByKeywords("小");
        list.forEach(System.out::println);

    }
}