package com.coffee.life.hander;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.coffee.life.common.model.response.CommonCode;
import com.coffee.life.common.model.response.ResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAccessDeniedHandler  implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) {
        response.setStatus(HttpStatus.OK.value());
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        ResponseResult responseResult = new ResponseResult(CommonCode.NO_PERMISSION, null);

        try {
            response.getWriter().write(JSONObject.toJSONString(responseResult, SerializerFeature.WriteMapNullValue));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
