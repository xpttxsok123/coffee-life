package com.coffee.life.oauth.api;

import com.coffee.life.oauth.request.LoginRequest;
import com.coffee.life.oauth.response.JwtResult;
import com.coffee.life.oauth.response.LoginResult;
import com.coffee.life.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Created by jay.
 */
@Api(value = "用户认证",description = "用户认证接口")
public interface AuthControllerApi {
    @ApiOperation("登录")
    public LoginResult login(LoginRequest loginRequest);

    @ApiOperation("退出")
    public ResponseResult logout();

    @ApiOperation("查询用户jwt令牌")
    public JwtResult userjwt();
}
