package com.item_bank.springboot.mapper.sql;

import com.item_bank.springboot.pojo.Teacher;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Description:教师代理sql生产工厂
 * @Author: Mt.Li
 * @Create: 2019-10-25 14:08
 */
public class TeacherSqlProvider {
    /**
     * 自动生成添加教师的sql
     * @param teacher
     * @return
     */
    public String insertTeacher(Teacher teacher){
        String sql = new SQL()
                .INSERT_INTO("teacher")
                .VALUES("t_id, t_type","#{t_id}, #{t_type}")
                .VALUES("school, faculty","#{school}, #{faculty}")
                .VALUES("t_subject, job_number","#{t_subject}, #{job_number}")
                .VALUES("password, name","#{password}, #{name}")
                .VALUES("id_number, email","#{id_number}, #{email}")
                .VALUES("telephone, a_id","#{telephone}, #{a_id}")
                .toString();
        return sql;
    }

    /**
     * 自动生成删除教师的sql
     * @param teacher
     * @return
     */
    public String deleteTeacher(Teacher teacher){
        return new SQL(){{
            DELETE_FROM("teacher");
            if(teacher.getJob_number() !=null){
                WHERE("job_number = #{job_number}");
            }
        }}.toString();
    }

    /**
     * 自动生成修改教师的sql
     * @param teacher
     * @return
     */
    public String updateTeacher(Teacher teacher){
        return new SQL(){{
            UPDATE("teacher");
            if(teacher.getT_type() !=null){
                SET("t_type = #{t_type}");
            }
            if(teacher.getSchool() !=null){
                SET("school = #{school}");
            }
            if(teacher.getFaculty() !=null){
                SET("faculty = #{faculty}");
            }
            if(teacher.getT_subject() !=null){
                SET("t_subject = #{t_subject}");
            }
            if(teacher.getJob_number() !=null){
                SET("job_number = #{job_number}");
            }
            if(teacher.getPassword() !=null){
                SET("password = #{password}");
            }
            if(teacher.getName() !=null){
                SET("name = #{name}");
            }
            if(teacher.getId_number() !=null){
                SET("id_number = #{id_number}");
            }
            if(teacher.getEmail() !=null){
                SET("email = #{email}");
            }
            if(teacher.getTelephone() !=null){
                SET("telephone = #{telephone}");
            }
            if(teacher.getT_id() !=null){
                WHERE("t_id = #{t_id}");
            }
        }}.toString();
    }

    /**
     * 自动生成查询教师的sql（条件查询）
     * @param teacher
     * @return
     */
    public String selectTeacherByConditions(Teacher teacher){
        return new SQL(){{
            SELECT("*");
            FROM("teacher");
            if(teacher.getSchool() !=null){
                WHERE("school = #{school}");
            }
            if(teacher.getFaculty() !=null){
                WHERE("faculty = #{faculty}");
            }
            if(teacher.getT_subject() !=null){
                WHERE("t_subject = #{t_subject}");
            }
            if(teacher.getId_number() !=null){
                WHERE("id_number = #{id_number}");
            }
            if(teacher.getEmail() !=null){
                WHERE("email = #{email}");
            }
        }}.toString();
    }
}
