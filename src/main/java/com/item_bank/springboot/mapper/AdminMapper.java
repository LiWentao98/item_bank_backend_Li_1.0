package com.item_bank.springboot.mapper;

/*
管理员类的Mapper接口
 */

import com.item_bank.springboot.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository("adminMapper")
public interface AdminMapper {
    //根据职工号和登陆密码查询管理员
    @Select("select * from admin where job_number=#{jobNumber} and password=#{password} ")
    public Admin findAdminByJobNumberAndPassword(@Param("jobNumber") String jobNumber, @Param("password") String password);
}
