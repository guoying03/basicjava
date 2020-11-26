package com.gyy.sm.service;

import com.gyy.sm.utils.ResultEntity;

/**
 * @ClassName AdminService
 * @Description TODO
 * @Author GYY
 * @Date 2020/11/21
 **/

public interface AdminService {
    /**
     * 管理员登录
     *
     * @param account :账号
     * @param password :密码
     * @return ResultEntity:返回结果
     */
    ResultEntity adminLogin(String account, String password);
}
