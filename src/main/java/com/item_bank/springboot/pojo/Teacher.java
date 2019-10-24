package com.item_bank.springboot.pojo;

import lombok.Data;

/**
 * @Description:教师类
*/
@Data
public class Teacher {
    private Integer t_id;//教师唯一标识
    private String t_type;//教师类型
    private String school;//所属学校
    private String faculty;//所属院系
    private String t_subject;//操作科目
    private String job_number;//职工号
    private String password;//登录密码
    private String name;//姓名
    private String id_number;//身份证号
    private String email;//绑定邮箱
    private String telephone;//绑定手机号
    private Integer a_id;//所属管理员id
}
