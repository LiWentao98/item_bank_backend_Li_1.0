package com.item_bank.springboot.mapper.sql;

import com.item_bank.springboot.pojo.Question;
import com.item_bank.springboot.pojo.Teacher;
import com.item_bank.springboot.service.question.QUploadService;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Description: 试题代理SQL生产工厂
 * @Author: Mt.Li
 * @Create: 2019-10-20 22:08
 */
public class QuestionSqlProvider {

    /**
     * 根据传来的试题对象参数组装sql
     * @param question
     * @return sql.toString()
     */
    public String insertQuestion(Question question) {//参数暂且不用，后面加动态判断再用
        String sql = new SQL()
                .INSERT_INTO("question")
                .VALUES("q_id, q_state","#{q_id}, #{q_state}")
                .VALUES("q_content","#{q_content}")
                .VALUES("q_image_url, q_type","#{q_image_url}, #{q_type}")
                .VALUES("q_major, q_subject","#{q_major}, #{q_subject}")
                .VALUES("chapter, difficulty","#{chapter}, #{difficulty}")
                .VALUES("knowledge, upload_time","#{knowledge}, #{upload_time}")
                .VALUES("t_id","#{t_id}")
                .toString();
        return sql;
    }

    /**
     * 根据传来的试题id组装sql
     * @param question
     * @return sql.toString()
     */
    public String deleteQuestion(Question question){
        return new SQL() {{
            DELETE_FROM("question");
            if (question.getQ_id() != null) {//参数不为空
                    WHERE("q_id = #{q_id}");
            }
        }}.toString();
    }

    /**
     * 根据传来的试题对象参数组装sql
     * @param question
     * @return sql.toString()
     */
    public String updateQuestion(Question question){
        return new SQL() {{
            UPDATE("question");
            if (question.getQ_state() != null) {
                SET("q_state = #{q_state}");
            }
            if (question.getQ_content() != null) {
                SET("q_content = #{q_content}");
            }
            if (question.getQ_image_url() != null) {
                SET("q_image_url = #{q_image_url}");
            }
            if (question.getQ_type() != null) {
                SET("q_type = #{q_type}");
            }
            if (question.getQ_major() != null) {
                SET("q_major = #{q_major}");
            }
            if (question.getQ_subject() != null) {
                SET("q_subject = #{q_subject}");
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
                SET("upload_time = #{upload_time}");
            }
            if (question.getQ_id() != null) {//参数不为空
                WHERE("q_id = #{q_id}");
            }
        }}.toString();
    }

    /**
     * 根据前端传来的条件组装查询sql
     * @param question
     * @return sql.toString()
     */
    public String selectByCondition(Question question){
        return new SQL(){{
            SELECT("*");
            FROM("question");
            if(question.getQ_type() !=null){
                WHERE("q_type = #{q_type}");
            }
            if(question.getQ_major() !=null){
                WHERE("q_major = #{q_major}");
            }
            if(question.getQ_subject() !=null){
                WHERE("q_subject = #{q_subject}");
            }
            if(question.getChapter() !=null){
                WHERE("chapter = #{chapter}");
            }
            if(question.getDifficulty() !=null){
                WHERE("difficulty = #{difficulty}");
            }
            if(question.getKnowledge() !=null){
                WHERE("knowledge = #{knowledge}");
            }
        }}.toString();
    }
}
