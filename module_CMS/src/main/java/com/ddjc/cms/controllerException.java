package com.ddjc.cms;

import com.ddjc.common.Exception.AppException;

import com.ddjc.common.RESTFUL.ResponseEnum;
import com.ddjc.common.RESTFUL.Result;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
//@Component
@Slf4j
public class controllerException {

    @ExceptionHandler(AppException.class)
    @ResponseBody
    public Result appException(AppException runtimeException) {

        log.error("AppException发生了");
        log.error(String.valueOf(runtimeException));

        return new Result(runtimeException.getCode(), runtimeException.getMessage(),null);
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result otherException(Exception e, HttpServletRequest request) {

        log.error("Exception发生了");
        log.error(String.valueOf(e));
//        request.setAttribute("e_msg", e.getMessage());
        return new Result(ResponseEnum.SYSTEM_ERROR, null);
    }

}
