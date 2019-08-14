package com.coffee.life.filter;

import com.alibaba.fastjson.JSON;
import com.coffee.life.api.ext.AuthToken;
import com.coffee.life.common.model.response.CommonCode;
import com.coffee.life.common.model.response.ResponseResult;
import com.coffee.life.service.AuthService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 身份校验过虑器
 *
 * @author jay
 * @version 1.0
 **/

@Component
public class LoginFilter extends ZuulFilter {

    @Autowired
    AuthService authService;

    private static final String LOGIN_URL = "/api/auth/userlogin";


    //过虑器的类型
    @Override
    public String filterType() {
        return "pre";
    }

    //过虑器序号，越小越被优先执行
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //返回true表示要执行此过虑器
        return true;
    }

    //过虑器的内容
    //测试的需求：过虑所有请求，判断头部信息是否有Authorization，如果没有则拒绝访问，否则转发到微服务。
    @Override
    public Object run() throws ZuulException {


        RequestContext requestContext = RequestContext.getCurrentContext();
        //得到request
        HttpServletRequest request = requestContext.getRequest();


        if (judgeLoginUrl(request.getRequestURI())) {
            return null;
        }


        String jwtFromHeader = authService.getJwtFromHeader(request);
        AuthToken authTokenFromRedis = authService.getJwtFromRedis(request);


        String jwtFromRedis = authTokenFromRedis == null ? "" : authTokenFromRedis.getJwt_token();

        if (StringUtils.isEmpty(jwtFromHeader) || StringUtils.isEmpty(jwtFromRedis) || !jwtFromHeader.equals(jwtFromRedis)) {
            //拒绝访问
            access_denied();
            return null;
        }
        //从redis取出jwt的过期时间
        long expire = authService.getExpire(request);
        if (expire < 0) {
            //拒绝访问
            access_denied();
            return null;
        }

        return null;
    }


    //拒绝访问
    private void access_denied() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        //得到response
        HttpServletResponse response = requestContext.getResponse();
        //拒绝访问
        requestContext.setSendZuulResponse(false);
        //设置响应代码
        requestContext.setResponseStatusCode(200);
        //构建响应的信息
        ResponseResult responseResult = new ResponseResult(CommonCode.UNAUTHENTICATED,null);
        //转成json
        String jsonString = JSON.toJSONString(responseResult);
        requestContext.setResponseBody(jsonString);
        //转成json，设置contentType
        response.setContentType("application/json;charset=utf-8");
    }

    private boolean judgeLoginUrl(String loginUrl) {
        if (LOGIN_URL.equals(loginUrl)) {
            return true;
        }
        return false;
    }


}
