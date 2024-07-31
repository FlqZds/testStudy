package com.ddjc.common.Exception;

import com.ddjc.common.RESTFUL.Result;
import com.ddjc.common.RESTFUL.ResponseEnum;
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

//jwt异常
    @ExceptionHandler({MalformedJwtException.class, SignatureException.class})
    @ResponseBody
    public Result doJwtException(Exception ex){
        ex.printStackTrace();
        return new Result(ResponseEnum.TOKEN_INVALIDATE,null);//令牌伪造
    }

    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseBody
    public Result doException(ExpiredJwtException ex){
        ex.printStackTrace();
        return new Result(ResponseEnum.TOKEN_EXPIRE,null);//令牌过期
    }


    //文件下载异常
    @ExceptionHandler(HttpMessageNotWritableException.class)
    @ResponseBody
    public Result doJwtException(HttpMessageNotWritableException hmnwe){
        log.warn("下载文件成功了，只是我们返回R不符合返回格式：" + hmnwe.getMessage());
        return new Result(ResponseEnum.LOCAL_DOWNLOAD_RETURN_WARNING, hmnwe.getMessage());
    }


}
