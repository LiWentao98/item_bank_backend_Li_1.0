package com.item_bank.springboot.mapper;

import com.item_bank.springboot.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/*
教师类的Mapper接口
 */

@Repository("teacherMapper")
public interface TeacherMapper {
    //根据职工号和登陆密码查询教师
    @Select("select * from teacher where job_number=#{jobNumber} and password=#{password} ")
    public Teacher findTeacherByJobNumberAndPassword(@Param("jobNumber") String jobNumber, @Param("password") String password);
}
