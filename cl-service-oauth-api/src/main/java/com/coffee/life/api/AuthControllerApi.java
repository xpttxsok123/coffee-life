package com.coffee.life.api;

import com.coffee.life.api.request.LoginRequest;
import com.coffee.life.api.response.JwtResult;
import com.coffee.life.api.response.LoginResult;
import com.coffee.life.common.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Created by jay.
 */
@Api(value = "用户认证",description = "用户认证中心")
public interface AuthControllerApi {
    @ApiOperation("登录")
    public LoginResult login(LoginRequest loginRequest);

    @ApiOperation("退出")
    public ResponseResult logout();

    @ApiOperation("查询用户jwt令牌")
    public JwtResult userjwt();
}
