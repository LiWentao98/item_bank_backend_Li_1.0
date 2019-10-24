package com.item_bank.springboot;

import com.item_bank.springboot.pojo.Question;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Description:测试动态SQL能否返回完整的sql语句
 * @Author: Mt.Li
 * @Create: 2019-10-21 19:51
 */
public class TestMultiSql {
    public static void main(String[] args) {
        MultiSql multiSql = new MultiSql();
//        System.out.println(multiSql.insertPersonSql3());
//        //测试得出，两者得到的结果一样
        Question question = new Question();
        question.setQ_id(5);
        question.setDifficulty("简单");
        question.setKnowledge("数据结构");
        System.out.println(multiSql.insertPersonSql4(question));
        System.out.println(multiSql.insertPersonSql5(question));
    }
}
