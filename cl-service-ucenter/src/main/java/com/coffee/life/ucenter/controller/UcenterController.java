package com.coffee.life.ucenter.controller;

import com.coffee.life.log.starter.annotation.LogAnnotation;
import com.coffee.life.framework.client.XcServiceList;
import com.coffee.life.ucenter.api.UcenterControllerApi;
import com.coffee.life.ucenter.model.XcUserExt;
import com.coffee.life.ucenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UcenterController implements UcenterControllerApi {
    @Autowired
    UserService userService;

    @Override
    @GetMapping("/getuserext")
    public XcUserExt getUserext(@RequestParam("username") String username) {
        return userService.getUserExt(username);
    }

    @GetMapping("/test")
    @LogAnnotation(module = XcServiceList.CL_SERVICE_UCENTER)
    public String test(@RequestParam("name") String name) {
        return "test";
    }
}
