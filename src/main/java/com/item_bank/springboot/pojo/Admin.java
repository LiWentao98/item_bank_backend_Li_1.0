package com.item_bank.springboot.pojo;

import lombok.Data;

/**
 * @Description:管理员类
*/

@Data
public class Admin {
    private Integer a_id;//管理员唯一标识
    private String a_type;//管理员类型
    private String school;//所属学校
    private String faculty;//所属院系
    private String job_number;//职工号
    private String password;//登陆密码
    private String name;//姓名
    private String id_number;//身份证号
    private String email;//绑定邮箱
    private String telephone;//绑定手机号
}
