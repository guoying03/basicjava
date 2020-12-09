package com.gyy.sm.factory;

import com.gyy.sm.service.AdminService;
import com.gyy.sm.service.ClazzService;
import com.gyy.sm.service.DepartmentService;
import com.gyy.sm.service.StudentService;
import com.gyy.sm.service.impl.AdminServiceImpl;
import com.gyy.sm.service.impl.ClazzServiceImpl;
import com.gyy.sm.service.impl.DepartmentServiceImpl;
import com.gyy.sm.service.impl.StudentServiceImpl;

/**
 * @ClassName ServiceFactory
 * @Description TODO
 * @Author GYY
 * @Date 2020/11/21
 **/
public class ServiceFactory {
    public static AdminService getAdminServiceInstance(){

        return new AdminServiceImpl();
    }

    public static DepartmentService getDepartmentServiceInstance(){

        return new DepartmentServiceImpl();
    }

    public static ClazzService getClazzServiceInstance(){
        return new ClazzServiceImpl();
    }


    public static StudentService getStudentServiceInstance(){
        return new StudentServiceImpl();
    }


}
