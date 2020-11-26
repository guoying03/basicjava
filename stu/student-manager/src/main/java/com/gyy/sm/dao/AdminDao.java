package com.gyy.sm.dao;

import com.gyy.sm.entity.Admin;

import java.sql.SQLException;

/**
 * @ClassName AdminDao
 * @Description TODO
 * @Author GYY
 * @Date 2020/11/21
 **/

public interface AdminDao {
    /**
     * 根据账号查找管理员
     *
     * @param account：找好入参
     * @return Admin：管理员信息
     * @throws SQLException ：该方法会抛出SQL异常
     */
    Admin findAdminByAccount(String account) throws SQLException;

}
