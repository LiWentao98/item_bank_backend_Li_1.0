package com.item_bank.springboot.controller.user;

/*
AdminController
管理员的视图控制层
 */

import com.item_bank.springboot.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserServiceImpl userService;

    @ResponseBody
    @PostMapping("/login")
    public HashMap login(@RequestBody Map map){
        String username = map.get("username").toString();
        String password = map.get("password").toString();
        for (Object value : map.values()) {
            System.out.println("key = " + value);
        }
        return null;
    }
}
