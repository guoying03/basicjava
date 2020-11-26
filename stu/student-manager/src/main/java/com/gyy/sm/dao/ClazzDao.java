package com.gyy.sm.dao;

import com.gyy.sm.dao.impl.ClazzDaoImpl;
import com.gyy.sm.entity.Clazz;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName ClazzDao
 * @Description TODO
 * @Author GYY
 * @Date 2020/11/23
 **/

public interface ClazzDao {
    /**
     * 按照院系id查询班级
     *
     * @param departmentId 院系id
     * @return List<CClass> 院系班级集合
     * @throws SQLException 异常
     */
    List<Clazz> selectByDepartmentId(int departmentId) throws SQLException;

    /**
     * 新增班级
     * @param clazz 入参班级实体
     * @return int
     * @throws SQLException 异常
     */
    int insertClazz(Clazz clazz) throws SQLException;

    int deleteClazz(Integer id) throws SQLException;
}

