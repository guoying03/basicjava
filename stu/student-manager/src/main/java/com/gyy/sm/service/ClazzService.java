package com.gyy.sm.service;

import com.gyy.sm.entity.Clazz;

import java.util.List;

/**
 * @ClassName ClazzService
 * @Description TODO
 * @Author GYY
 * @Date 2020/11/23
 **/

public interface ClazzService {
    /**
     *
     * @param department 班级
     * @return int
     */
    List<Clazz> getClazzByDepId(int department);

    /**
     * 新增班级
     *
     * @param clazz 班级实体
     * @return int
     */

    int addClazz(Clazz clazz);

    int deleteClazz(Integer id);
}
