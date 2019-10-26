package com.item_bank.springboot.service.user.impl;

/*
UserService的实现类
 */

import com.item_bank.springboot.mapper.AdminMapper;
import com.item_bank.springboot.mapper.TeacherMapper;
import com.item_bank.springboot.pojo.Admin;
import com.item_bank.springboot.pojo.Teacher;
import com.item_bank.springboot.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    //自动注入mapper
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    AdminMapper adminMapper;

    @Override
    public HashMap teacherLogin(String jobNumber, String password) {
        HashMap<String, Object> data = new HashMap<String, Object>();
        Teacher teacher = teacherMapper.findTeacherByJobNumberAndPassword(jobNumber,password);
        data.put("user", teacher);
        if(teacher != null){
            data.put("msg", "登录成功！");
        }else {
            data.put("msg", "密码错误！");
        }
        return data;
    }

    @Override
    public HashMap adminLogin(String jobNumber, String password) {
        HashMap<String, Object> data = new HashMap<String, Object>();
        Admin admin = adminMapper.findAdminByJobNumberAndPassword(jobNumber,password);
        data.put("user", admin);
        if(admin != null){
            data.put("msg", "登录成功！");
        }else {
            data.put("msg", "密码错误！");
        }
        return data;
    }

    @Override
    public void add(Teacher teacher) {
        teacherMapper.addTeacher(teacher);
    }

    @Override
    public void delete(Teacher teacher) {
        teacherMapper.deleteTeacher(teacher);
    }

    @Override
    public void edit(Teacher teacher) {
        teacherMapper.updateTeacher(teacher);
    }

    @Override
    public List<Teacher> selectByConditions(Teacher teacher) {
        return teacherMapper.selectTeacherByConditions(teacher);
    }
}
