package com.coffee.life.controller;

import com.coffee.life.api.feign.UserFeign;
import com.coffee.life.log.stater.annotation.LogAnnotation;
import com.coffee.life.api.app.UserApp;
import com.coffee.life.api.entity.XcUserExt;
import com.coffee.life.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jay
 * @version 1.0
 **/
@RestController
@RequestMapping("/ucenter")
public class UcenterController implements UserFeign {
    @Autowired
    UserService userService;

    @Override
    @GetMapping("/getuserext")
    public XcUserExt getUserext(@RequestParam("username") String username) {
        return userService.getUserExt(username);
    }


    @PreAuthorize("hasAuthority('course_teachplan_list1')")
    @GetMapping("/test1")
    public String findTeachplanList(String username) {
        return username;
    }

    @GetMapping("/test")
    @LogAnnotation(module = UserApp.CL_SERVICE_UCENTER)
    public String test(@RequestParam("username") String username,Integer id) {
        return username;
    }
}
