package com.gyy.sm.dao;

import com.gyy.sm.VO.StudentVo;
import com.gyy.sm.entity.Clazz;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName StudentDao
 * @Description TODO
 * @Author GYY
 * @Date 2020/11/26
 **/

public interface StudentDao {
    /**
     * 查询所有学生（视图对象）
     *
     * @return 学生视图列表数据
     * @throws SQLException  异常
     */
    List<StudentVo> selectAll() throws SQLException;

    /**
     * 根据院系id查询学生
     *
     * @param depId 院系id
     * @return list
     * @throws SQLException 异常
     */
    List<StudentVo> selectByDepId(int depId) throws SQLException;

    /**
     * 根基班级id查询学生
     *
     * @param classId 班级id
     * @return list
     * @throws SQLException 异常
     */
    List<StudentVo> selectByClassId(int classId) throws SQLException;

    /**
     * 根据关键字查询学生
     *
     * @param keywords 关键字
     * @return list
     * @throws SQLException 异常
     */
    List<StudentVo> selectByKeywords(String keywords) throws SQLException;

    List<StudentVo> getAll() throws SQLException;


}
