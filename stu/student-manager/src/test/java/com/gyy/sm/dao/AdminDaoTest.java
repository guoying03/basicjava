package com.gyy.sm.dao;

import com.gyy.sm.entity.Admin;
import com.gyy.sm.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class AdminDaoTest {

    private final AdminDao adminDao = DaoFactory.getAdminDaoInstance();

    @Test
    public void findAdminByAccount() {
        Admin admin;
        try{
            admin = adminDao.findAdminByAccount("2834168063@qq.com");
            assertEquals("郭莹莹", admin.getAdminName());
            System.out.println(admin);
        }catch (SQLException e ){
            System.err.println(e.getMessage());
        }
    }
}