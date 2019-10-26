package com.item_bank.springboot.service.user;

/*
用户通用的Service接口
 */

import com.item_bank.springboot.pojo.Teacher;

import java.util.HashMap;
import java.util.List;

public interface UserService {
    //教师类型的用户登录接口
    public HashMap teacherLogin(String jobNumber, String password);
    //管理员类型的用户登录接口
    public HashMap adminLogin(String jobNumber, String password);
    //教师类型的用户添加接口
    public void add(Teacher teacher);
    //教师类型的用户删除接口
    public void delete(Teacher teacher);
    //教师类型的用户更新接口
    public void edit(Teacher teacher);
    //教师类型的用户查询接口（多条件）
    public List<Teacher> selectByConditions(Teacher teacher);
}
