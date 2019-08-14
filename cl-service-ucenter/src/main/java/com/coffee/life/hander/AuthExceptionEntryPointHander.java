package com.coffee.life.hander;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.coffee.life.common.model.response.CommonCode;
import com.coffee.life.common.model.response.ResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthExceptionEntryPointHander implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) {

        response.setStatus(HttpStatus.OK.value());
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        ResponseResult responseResult = new ResponseResult(CommonCode.UNAUTHENTICATED, null);

        try {
            response.getWriter().write(JSONObject.toJSONString(responseResult, SerializerFeature.WriteMapNullValue));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}