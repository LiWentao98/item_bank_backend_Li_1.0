package com.item_bank.springboot.service.question;

/*
试题上传相关的Service接口
 */

import com.item_bank.springboot.pojo.Question;
import com.item_bank.springboot.pojo.Teacher;

import java.util.List;

public interface QUploadService {
    //试题保存接口
    void add(Question question);
    //试题删除接口
    void delete(Question question);
    //试题修改接口
    void edit(Question question);
    //试题查询接口(通过教师ID）
    List<Question> selectByTId(Integer id);
    //试题查询接口(通过其他条件查询)
    List<Question> selectByCondition(Question question);
}
