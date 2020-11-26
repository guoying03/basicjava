package com.gyy.sm.service;

import com.gyy.sm.factory.ServiceFactory;
import com.gyy.sm.utils.ResultEntity;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.*;

public class AdminServiceTest {

    private final AdminService adminService = ServiceFactory.getAdminServiceInstance();

    @Test
    public void adminLogin() {
        ResultEntity resultEntity = adminService.adminLogin("2834168063@qq.com","guoying0000");
        assertEquals(0,resultEntity.getCode());
        System.out.println(resultEntity);
    }
}