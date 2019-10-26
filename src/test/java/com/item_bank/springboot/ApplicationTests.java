package com.item_bank.springboot;

import com.item_bank.springboot.service.user.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

//	@Autowired
//	TeacherMapper teacherMapper;
	@Autowired
	UserServiceImpl userService;

//	@Test
//	public void testTeacherMapper() {
//		Teacher teacher = teacherMapper.findTeacherByJobNumberAndPassword("222222222", "222222");
//		System.out.println(teacher);
//	}

	@Test
	public void testLoginService() {
		HashMap data = userService.teacherLogin("222222222", "222222");
		System.out.println(data);
	}

}
