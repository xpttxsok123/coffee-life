package com.coffee.life.controller;

import com.coffee.life.api.AuthControllerApi;
import com.coffee.life.api.ext.AuthToken;
import com.coffee.life.api.request.LoginRequest;
import com.coffee.life.api.response.AuthCode;
import com.coffee.life.common.client.XcServiceList;
import com.coffee.life.common.exception.ExceptionCast;
import com.coffee.life.common.model.response.CommonCode;
import com.coffee.life.common.model.response.ResponseResult;
import com.coffee.life.log.stater.annotation.LogAnnotation;
import com.coffee.life.service.AuthService;
import com.coffee.life.utils.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author jay
 * @version 1.0
 **/
@RestController
@RequestMapping("/auth")
public class AuthController implements AuthControllerApi {

    @Value("${auth.clientId}")
    String clientId;
    @Value("${auth.clientSecret}")
    String clientSecret;
    @Value("${auth.cookieDomain}")
    String cookieDomain;
    @Value("${auth.cookieMaxAge}")
    int cookieMaxAge;

    @Autowired
    AuthService authService;

    @Override
    @PostMapping("/userlogin")
    @LogAnnotation(module = XcServiceList.CL_SERVICE_UCENTER_AUTH)
    public ResponseResult login(LoginRequest loginRequest) {
        if(loginRequest == null || StringUtils.isEmpty(loginRequest.getUsername())){
            ExceptionCast.cast(AuthCode.AUTH_USERNAME_NONE);
        }
        if(loginRequest == null || StringUtils.isEmpty(loginRequest.getPassword())){
            ExceptionCast.cast(AuthCode.AUTH_PASSWORD_NONE);
        }
        //账号
        String username = loginRequest.getUsername();
        //密码
        String password = loginRequest.getPassword();

        //申请令牌
        AuthToken authToken =  authService.login(username,password,clientId,clientSecret);

        //用户身份令牌
        //String access_token = authToken.getAccess_token();


        //将令牌存储到cookie
        //this.saveCookie(access_token);

        //return new LoginResult(CommonCode.SUCCESS,access_token);
        return new ResponseResult(CommonCode.SUCCESS,authToken);
    }

/*    //将令牌存储到cookie
    private void saveCookie(String token){

        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        //HttpServletResponse response,String domain,String path, String name, String value, int maxAge,boolean httpOnly
        CookieUtil.addCookie(response,cookieDomain,"/","uid",token,cookieMaxAge,false);

    }
    //从cookie删除token
    private void clearCookie(String token){

        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        //HttpServletResponse response,String domain,String path, String name, String value, int maxAge,boolean httpOnly
        CookieUtil.addCookie(response,cookieDomain,"/","uid",token,0,false);

    }*/

    //退出
    @Override
    @PostMapping("/userlogout")
    public ResponseResult logout() {
        //取出cookie中的用户身份令牌
        String uid = getTokenFormCookie();
        //删除redis中的token
        boolean result = authService.delToken(uid);
        //清除cookie
        //this.clearCookie(uid);
        return new ResponseResult(CommonCode.SUCCESS,null);
    }

    @Override
    @GetMapping("/userjwt")
    public ResponseResult userjwt() {
        //取出cookie中的用户身份令牌
        String uid = getTokenFormCookie();
        if(uid == null){
            return new ResponseResult(CommonCode.FAIL,null);
        }

        //拿身份令牌从redis中查询jwt令牌
        AuthToken userToken = authService.getUserToken(uid);
        if(userToken!=null){
            //将jwt令牌返回给用户
            String jwt_token = userToken.getJwt_token();
            return new ResponseResult(CommonCode.SUCCESS,jwt_token);
        }
        return null;
    }

    //取出cookie中的身份令牌
    private String getTokenFormCookie(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String, String> map = CookieUtil.readCookie(request, "uid");
        if(map!=null && map.get("uid")!=null){
            String uid = map.get("uid");
            return uid;
        }
        return null;
    }
}
