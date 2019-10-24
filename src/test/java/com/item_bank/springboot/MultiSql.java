package com.item_bank.springboot;

import com.item_bank.springboot.pojo.Question;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Description:动态sql编写测试
 * @Author: Mt.Li
 * @Create: 2019-10-21 19:54
 */
public class MultiSql {
    //非常规写法
    public String insertPersonSql() {
        return new SQL() {{
            INSERT_INTO("PERSON");
            VALUES("ID, FIRST_NAME", "#{id}, #{firstName}");
            VALUES("LAST_NAME", "#{lastName}");
        }}.toString();
    }

    //常规写法
    public String insertPersonSql2() {
        String sql = new SQL()
                .INSERT_INTO("question")
                .VALUES("ID, FIRST_NAME", "#{id}, #{firstName}")
                .VALUES("LAST_NAME", "#{lastName}")
                .toString();
        return sql;
    }
    //insert into question (q_id,q_state,q_url,q_type,q_major,q_subject,chapter,difficulty,knowledge,upload_time,t_id) values(#{qId}，#{qState}，#{qUrl}，#{qType}，#{qMajor}，#{qSubject}，#{chapter}，#{difficulty}，#{knowledge}，#{uploadTime}，#{tId})"
    public String insertPersonSql3() {
        String sql = new SQL()
                .INSERT_INTO("question")
                .VALUES("q_id, q_state","#{qId}, #{qState}")
                .VALUES("q_url, q_type","#{qUrl}, #{qType}")
                .VALUES("q_major, q_subject","#{qMajor}, #{qSubject}")
                .VALUES("chapter, difficulty","#{chapter}, #{difficulty}")
                .VALUES("knowledge, upload_time","#{knowledge}, #{uploadTime}")
                .VALUES("t_id","#{tId}")
                .toString();
        return sql;
    }

    public String insertPersonSql4(Question question) {
        return new SQL() {{
            UPDATE("question");
            if (question.getQ_state() != null) {
                SET("q_state = #{qState}");
            }
            if (question.getQ_image_url() != null) {
                SET("q_url = #{qUrl}");
            }
            if (question.getQ_type() != null) {
                SET("q_type = #{qType}");
            }
            if (question.getQ_major() != null) {
                SET("q_major = #{qMajor}");
            }
            if (question.getQ_subject() != null) {
                SET("q_subject = #{qSubject}");
            }
            if (question.getChapter() != null) {
                SET("chapter = #{chapter}");
            }
            if (question.getDifficulty() != null) {
                SET("difficulty = #{difficulty}");
            }
            if (question.getKnowledge() != null) {
                SET("knowledge = #{knowledge}");
            }
            if (question.getUpload_time() != null) {
                SET("upload_time = #{uploadTime}");
            }
            if (question.getQ_id() != null) {//参数不为空
                WHERE("q_id = #{qId}");
            }
        }}.toString();
    }

    public String insertPersonSql5(Question question){
        return new SQL() {{
            DELETE_FROM("question");
            if (question.getQ_id() != null) {//参数不为空
                WHERE("q_id = #{qId}");
            }
        }}.toString();
    }

    public String insertPersonSql6(Integer id){
        return new SQL() {{
            SELECT("*");
           FROM("question");
        }}.toString();
    }
}
