package com.ddjc.teststudy.exception;

import com.ddjc.teststudy.common.R;
import com.ddjc.teststudy.common.ResponseEnum;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
//@Component
public class controllerException {

    @ExceptionHandler(AppException.class)
    @ResponseBody
    public R appException(AppException runtimeException) {

        System.out.println("AppException发生了");
        System.out.println(runtimeException);

        return new R(runtimeException.getCode(), runtimeException.getMessage(),null);
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R otherException(Exception e, HttpServletRequest request) {

        System.out.println("Exception发生了");
//        request.setAttribute("e_msg", e.getMessage());
        return new R(ResponseEnum.SYSTEM_ERROR, e.getMessage());
    }
}
