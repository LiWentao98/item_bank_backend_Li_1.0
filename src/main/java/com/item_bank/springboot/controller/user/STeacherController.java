package com.item_bank.springboot.controller.user;

/*
SetAQuestionTeacherController
命题教师的视图控制层
 */

import com.item_bank.springboot.pojo.Question;
import com.item_bank.springboot.service.question.impl.QUploadServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@Controller
@RequestMapping("/s_teacher")
public class STeacherController {
    /**
     * 注入业务层
     */
    @Autowired
    QUploadServiceImpl qUploadService;

    /**
     * 保存试题信息
     * @param question
     * @return
     */
    @ResponseBody
    @PostMapping("/save_question")
    public Question saveQuestion(@RequestBody Question question){
        log.info("saveQuestion:{}",question);

        qUploadService.add(question);

        return null;
    }

    /**
     * 删除试题
     * @param question
     * @return
     */
    @ResponseBody
    @DeleteMapping("/delete_question")
    public Question deleteQuestion(@RequestBody Question question){
        log.info("deleteQuestion:{}",question);

        qUploadService.delete(question);

        return null;
    }

    /**
     * 根据id和对象参数修改试题信息
     * @param question(从question中获取t_id)
     * @return
     */
    @ResponseBody
    @PutMapping("update_question")
    public Question updateQuestion(@RequestBody Question question){

        log.info("updateQuestion:{}",question);

        qUploadService.edit(question);

        return null;
    }

    /**
     * 根据教师id获取该教师所有试题信息
     * @return
     */
    @ResponseBody
    @GetMapping("/select_question_by_t_id")
    public List<Question> selectQuestionByTId(@RequestBody Question question){
        log.info("t_id:{}",question.getT_id());
        Integer id = question.getT_id();
        return qUploadService.selectByTId(id);
    }

    /**
     * 根据相应的条件查询试题信息,"requestParam"为前端传来的值
     * required=false代表该值可以为空
     * @param qType
     * @param qMajor
     * @param qSubject
     * @param chapter
     * @param difficulty
     * @param knowledge
     * @return
     */
    @ResponseBody
    @GetMapping("/select_question_by_condition")
    public List<Question> selectQuestionByCondition(@RequestParam(value = "qType",required=false) String qType, @RequestParam(value = "qMajor",required=false) String qMajor,
                                                    @RequestParam(value = "qSubject",required=false) String qSubject, @RequestParam(value = "chapter",required=false) String chapter,
                                                    @RequestParam(value = "difficulty",required=false) String difficulty, @RequestParam(value = "knowledge",required=false) String knowledge){
        Question question = new Question();
        question.setQ_type(qType);
        question.setQ_major(qMajor);
        question.setQ_subject(qSubject);
        question.setChapter(chapter);
        question.setDifficulty(difficulty);
        question.setKnowledge(knowledge);
        return qUploadService.selectByCondition(question);
    }
}
