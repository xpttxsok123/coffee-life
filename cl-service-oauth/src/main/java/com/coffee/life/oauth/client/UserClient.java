package com.coffee.life.oauth.client;

import com.coffee.life.framework.client.XcServiceList;
import com.coffee.life.ucenter.model.XcUserExt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jay.
 */
@FeignClient(value = XcServiceList.CL_SERVICE_UCENTER)
public interface UserClient {
    //根据账号查询用户信息
    @GetMapping("/ucenter/getuserext")
    public XcUserExt getUserext(@RequestParam("username") String username);
}
