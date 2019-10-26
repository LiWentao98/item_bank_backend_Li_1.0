package com.item_bank.springboot.mapper;

import com.item_bank.springboot.mapper.sql.TeacherSqlProvider;
import com.item_bank.springboot.pojo.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
教师类的Mapper接口
 */

@Repository("teacherMapper")
public interface TeacherMapper {
    /**
     *命题教师和审题教师共有操作
     */

    //根据职工号和登陆密码查询教师
    @Select("select * from teacher where job_number=#{jobNumber} and password=#{password} ")
    public Teacher findTeacherByJobNumberAndPassword(@Param("jobNumber") String jobNumber, @Param("password") String password);

    //添加教师
    @InsertProvider(type = TeacherSqlProvider.class,method = "insertTeacher")
    public void addTeacher(Teacher teacher);

    //根据职工号删除教师
    @DeleteProvider(type = TeacherSqlProvider.class,method = "deleteTeacher")
    public void deleteTeacher(Teacher teacher);

    //修改教师信息
    @UpdateProvider(type = TeacherSqlProvider.class,method = "updateTeacher")
    public void updateTeacher(Teacher teacher);

    //根据条件查询教师
    @SelectProvider(type = TeacherSqlProvider.class,method = "selectTeacherByConditions")
    public List<Teacher> selectTeacherByConditions(Teacher teacher);
}
