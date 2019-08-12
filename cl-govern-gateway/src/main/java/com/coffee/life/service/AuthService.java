package com.coffee.life.service;

import com.alibaba.fastjson.JSON;
import com.coffee.life.api.ext.AuthToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @author jay
 * @version 1.0
 **/
@Service
public class AuthService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //从头取出jwt令牌
    public String getJwtFromHeader(HttpServletRequest request) {
        //取出头信息
        String authorization = request.getHeader("Authorization");
        if (StringUtils.isEmpty(authorization)) {
            return null;
        }
        if (!authorization.startsWith("Bearer ")) {
            return null;
        }
        //取到jwt令牌
        String jwt = authorization.substring(7);
        return jwt;

    }


    private String getJtiTokenFromHeader(HttpServletRequest request) {
        //取出头信息
        return request.getHeader("jti");
    }

/*    //从cookie取出token
    //查询身份令牌
    public String getTokenFromCookie(HttpServletRequest request) {
        Map<String, String> cookieMap = CookieUtil.readCookie(request, "uid");
        String access_token = cookieMap.get("uid");
        if (StringUtils.isEmpty(access_token)) {
            return null;
        }
        return access_token;
    }*/

    //查询令牌的有效期
    public long getExpire(HttpServletRequest request) {
        //key
        String key = "user_token:" + getJtiTokenFromHeader(request);
        Long expire = stringRedisTemplate.getExpire(key, TimeUnit.SECONDS);
        return expire;
    }

    //从redis查询令牌
    public AuthToken getJwtFromRedis(HttpServletRequest request) {

        String key = "user_token:" + getJtiTokenFromHeader(request);
        //从redis中取到令牌信息
        String value = stringRedisTemplate.opsForValue().get(key);
        //转成对象
        try {
            AuthToken authToken = JSON.parseObject(value, AuthToken.class);
            return authToken;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
