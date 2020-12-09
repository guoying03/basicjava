package com.gyy.sm.dao;

import com.gyy.sm.entity.Clazz;
import com.gyy.sm.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ClazzDaoTest {

    private final ClazzDao clazzDao = DaoFactory.getClazzDaoInstance();

    @Test
    public void selectByDepartmentId() throws Exception{
        List<Clazz> clazzList = clazzDao.selectByDepartmentId(5);
        System.out.println(clazzList);
    }


    @Test
    public void selectAll() throws Exception{
        List<Clazz> clazzList = clazzDao.selectAll();
        System.out.println(clazzList);
    }
}