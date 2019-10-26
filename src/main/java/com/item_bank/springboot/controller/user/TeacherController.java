package com.item_bank.springboot.controller.user;

/*
TeacherController
教师的视图控制层
 */

import com.item_bank.springboot.pojo.Question;
import com.item_bank.springboot.pojo.Teacher;
import com.item_bank.springboot.service.user.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    //自动注入service
    @Autowired
    UserServiceImpl userService;

    /**
     * 根据用户名（job_name)和密码进行登录
     * @param map
     * @return
     */
    @ResponseBody
    @PostMapping("/login")
    public HashMap login(@RequestBody Map map){
        String username = map.get("username").toString();
        String password = map.get("password").toString();
        return userService.teacherLogin(username, password);
    }

    /**
     * 新增教师用户(管理员控制)
     * @param teacher
     */
    @ResponseBody
    @PostMapping("add_teacher")
    public void addTeacher(@RequestBody Teacher teacher){
        userService.add(teacher);
    }

    /**
     * 删除教师(管理员控制)
     * @param teacher
     */
    @ResponseBody
    @DeleteMapping("delete_teacher")
    public void deleteTeacher(@RequestBody Teacher teacher){//controller组修改接收参数，sql自动生成（sql中通过teacher.getJob_number获得job_number)
        log.info("teacher:{}",teacher);
        userService.delete(teacher);
    }

    /**
     * 修改教师信息（管理员、教师皆可操作）
     * @param teacher
     */
    @ResponseBody
    @PutMapping("update_teacher")
    public void updateTeacher(@RequestBody Teacher teacher){
        log.info("teacher:{}",teacher);

        userService.edit(teacher);
    }

    /**
     * 根据条件查询教师
     * @param school
     * @param faculty
     * @param tSubject
     * @param idNumber
     * @param email
     * @return
     */
    @ResponseBody
    @GetMapping("/select_teacher_by_conditions")
    public List<Teacher> selectTeacherByConditions(@RequestParam(value = "school",required=false) String school, @RequestParam(value = "faculty",required=false) String faculty,
                                                    @RequestParam(value = "tSubject",required=false) String tSubject, @RequestParam(value = "idNumber",required=false) String idNumber,
                                                    @RequestParam(value = "email",required=false) String email){
        Teacher teacher = new Teacher();
        teacher.setSchool(school);
        teacher.setFaculty(faculty);
        teacher.setT_subject(tSubject);
        teacher.setId_number(idNumber);
        teacher.setEmail(email);
        return userService.selectByConditions(teacher);
    }
}
