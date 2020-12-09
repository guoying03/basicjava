package com.gyy.sm.service;

import com.gyy.sm.VO.StudentVo;

import java.util.List;

/**
 * @ClassName StudentService
 * @Description TODO
 * @Author GYY
 * @Date 2020/11/27
 **/

public interface StudentService {
    List<StudentVo> selectAll();

    List<StudentVo> selectByDepId(int depId);

    List<StudentVo> selectByClassId(int classId);

    List<StudentVo> selectByKeywords(String keywords);
}
