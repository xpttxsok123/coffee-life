package com.coffee.life.manage.course.exception;


import com.coffee.life.framework.exception.ExceptionCatch;
import com.coffee.life.framework.model.response.CommonCode;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**课程管理自定义的异常类，其中定义异常类型所对应的错误代码
 * @author jay
 * @version 1.0
 **/
@ControllerAdvice//控制器增强
public class CustomExceptionCatch  extends ExceptionCatch {
    static {
        builder.put(AccessDeniedException.class, CommonCode.UNAUTHORISE);
    }
}
