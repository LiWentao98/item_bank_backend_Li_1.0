package com.item_bank.springboot.service.question.impl;

/*
QUploadService的实现类
 */

import com.item_bank.springboot.mapper.QuestionMapper;
import com.item_bank.springboot.pojo.Question;
import com.item_bank.springboot.service.question.QUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class QUploadServiceImpl implements QUploadService {

    //引入mapper资源
    @Autowired
    private QuestionMapper questionMapper;

    /**
     * 存储试题
     * @param question
     */
    @Override
    public void add(Question question) {
        questionMapper.insert(question);
    }

    @Override
    public void delete(Question question) {
        questionMapper.delete(question);
    }


    @Override
    public void edit(Question question) {
        questionMapper.update(question);
    }

    @Override
    public List<Question> selectByTId(Integer id) {
        return questionMapper.selectByTId(id);
    }

    @Override
    public List<Question> selectByCondition(Question question) {
        return questionMapper.selectByCondition(question);
    }


}
