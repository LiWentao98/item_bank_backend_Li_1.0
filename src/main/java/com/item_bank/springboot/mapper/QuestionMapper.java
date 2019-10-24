package com.item_bank.springboot.mapper;

/*
试题类的Mapper接口
 */

import com.item_bank.springboot.mapper.sql.QuestionSqlProvider;
import com.item_bank.springboot.pojo.Question;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("questionMapper")
public interface QuestionMapper {
    //试题保存
    @InsertProvider(type = QuestionSqlProvider.class,method = "insertQuestion")
    void insert(Question question);

    //试题删除
    @DeleteProvider(type = QuestionSqlProvider.class,method = "deleteQuestion")
    void delete(Question question);

    //试题修改
    @UpdateProvider(type = QuestionSqlProvider.class,method = "updateQuestion")
    void update(Question question);

    //查询所有试题（命题教师自己出的,根据命题老师id）
    @Select("select * from question as q left join teacher as t on t.t_id = q.t_id where t.t_id = #{id}")
    List<Question> selectByTId(Integer id);

   //根据（q_type、q_major、q_subject、chapter、difficulty、knowledge）查询试题，其中允许传空值
    @SelectProvider(type = QuestionSqlProvider.class,method = "selectByCondition")
    List<Question> selectByCondition(Question question);
}
