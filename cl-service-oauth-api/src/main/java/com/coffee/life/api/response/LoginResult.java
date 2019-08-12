package com.coffee.life.api.response;

import com.coffee.life.common.model.response.ResponseResult;
import com.coffee.life.common.model.response.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
public class LoginResult<T> extends ResponseResult {
    T t;
    public LoginResult(ResultCode resultCode, String token) {
        super(resultCode);
        this.token = token;
    }

    public LoginResult(ResultCode resultCode,T t) {
        super(resultCode);
        this.t = t;
    }
    private String token;
}
