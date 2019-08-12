package com.coffee.life.api.feign;

import com.coffee.life.api.entity.XcUserExt;
import com.coffee.life.api.app.UserApp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by jay.
 */

@Api(value = "用户中心", description = "用户中心管理")
@FeignClient(value = UserApp.CL_SERVICE_UCENTER)
public interface UserFeign {

    //根据账号查询用户信息
    @ApiOperation("根据用户账号查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", paramType = "query", dataType = "String")
    })
    @GetMapping("/ucenter/getuserext")
    public XcUserExt getUserext(@RequestParam("username") String username);


    @ApiOperation("用户接口测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "id", value = "用户ID", paramType = "query", dataType = "Integer")
    })
    @GetMapping("/ucenter/test")
    public String test(@RequestParam("username") String username, Integer id);

}
