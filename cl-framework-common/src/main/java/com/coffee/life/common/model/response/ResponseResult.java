package com.coffee.life.common.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ResponseResult<D> implements Response {

    //操作是否成功
    private boolean success = SUCCESS;

    //操作代码
    private int code = SUCCESS_CODE;

    //提示信息
    private String message;

    private D data;


    public ResponseResult(ResultCode resultCode, D data) {
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public ResponseResult SUCCESS(D d) {
        return new ResponseResult(CommonCode.SUCCESS, d);
    }
    public ResponseResult SUCCESS(ResultCode resultCode,D d) {
        return new ResponseResult(resultCode, d);
    }



    public ResponseResult FAIL(D d) {
        return new ResponseResult(CommonCode.FAIL, d);
    }
    public ResponseResult FAIL(ResultCode resultCode,D d) {
        return new ResponseResult(resultCode, d);
    }

}
