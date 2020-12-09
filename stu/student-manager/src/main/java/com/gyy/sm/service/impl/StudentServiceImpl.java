package com.gyy.sm.service.impl;

import com.gyy.sm.VO.StudentVo;
import com.gyy.sm.dao.StudentDao;
import com.gyy.sm.factory.DaoFactory;
import com.gyy.sm.service.StudentService;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Author GYY
 * @Date 2020/11/27
 **/
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao = DaoFactory.getStudentDaoInstance();

    @Override
    public List<StudentVo> selectAll(){

        List<StudentVo> studentVoList = null;
        try {
            studentVoList = studentDao.selectAll();
        }catch (SQLException e) {
            System.err.print("查询学生信息出现异常");
        }
        return studentVoList;
    }

    @Override
    public List<StudentVo> selectByDepId(int depId){
        List<StudentVo> list = null;
//        List<StudentVo> studentVoList = null;
        try{
           list = studentDao.selectByDepId(depId);
        }catch (SQLException e){
            System.err.print("查询院系信息出现异常");
        }
        return list;
    }

    @Override
    public List<StudentVo> selectByClassId(int classId) {
        List<StudentVo> studentVoList = null;
        try{
            studentVoList = studentDao.selectByClassId(classId);
        }catch (SQLException e) {
            System.err.print("查询班级信息出现异常");
        }
        return studentVoList;
    }

    @Override
    public List<StudentVo> selectByKeywords(String keywords) {
        List<StudentVo> studentVoList = null;
        try{
            studentVoList = studentDao.selectByKeywords(keywords);
        }catch (SQLException e) {
            System.err.print("查询信息出现异常");
        }
        return studentVoList;
    }
}
