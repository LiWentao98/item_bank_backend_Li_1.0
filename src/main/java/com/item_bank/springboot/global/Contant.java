package com.item_bank.springboot.global;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:常量类(可以声明试题状态)
 * @Author: Mt.Li
 * @Create: 2019-10-20 22:33
 */
public class Contant {

    //职务
    public static final String POST_SUPERM="超级管理员";
    public static final String POST_SCHOOLM="校级管理员";
    public static final String POST_ACADEMYM="院级管理员";
    public static final String POST_ANALYZE_QUESTION="审题老师";
    public static final String POST_ASSIGN_QUESTION="命题老师";
    //获取所有职务
    public static List<String> getPosts(){
        List<String> list = new ArrayList<String>();
        list.add(POST_SUPERM);
        list.add(POST_SCHOOLM);
        list.add(POST_ACADEMYM);
        list.add(POST_ANALYZE_QUESTION);
        list.add(POST_ASSIGN_QUESTION);
        return list;
    }

    //试题状态
    public static final String QUESTION_CREATED="新创建";
    public static final String QUESTION_SUBMIT="已提交";
    public static final String QUESTION_PASS="已通过";
    public static final String QUESTION_NPASS="未通过";
    public static final String QUESTION_RECHECK="待审核";
    public static final String QUESTION_ENTERING="已录入";
}
