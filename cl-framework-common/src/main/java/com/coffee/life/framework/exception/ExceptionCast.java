package com.coffee.life.framework.exception;

import com.coffee.life.framework.model.response.ResultCode;

/**
 * @author jay
 * @version 1.0
 * @create 2018-09-14 17:31
 **/
public class ExceptionCast {

    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}
