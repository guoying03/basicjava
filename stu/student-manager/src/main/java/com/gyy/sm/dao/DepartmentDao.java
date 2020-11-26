package com.gyy.sm.dao;

import com.gyy.sm.entity.Department;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName DepartmentDao
 * @Description TODO
 * @Author GYY
 * @Date 2020/11/21
 **/

public interface DepartmentDao {
    /**
     * 查询所有院系
     *
     * @return List<Department>
     * @throws SQLException 、异常
     */
    List<Department> getAll() throws SQLException;

    /**
     * 删除
     *
     * @param department
     * @return
     * @throw SQLException
     */
    int deleteDepartment(Department department, int id) throws SQLException;

    /**
     * 新增院系
     * @param department 入参
     * @return int
     * @throws SQLException 异常
     */
    int insertDepartment(Department department) throws SQLException;


}
