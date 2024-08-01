package com.ddjc.teststudy.common.Exception;


import com.ddjc.teststudy.common.RESTFUL.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  咱们程序中特殊异常
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppException extends RuntimeException{

    private String code;
    private String message;

    public AppException(ResponseEnum responseEnum){
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }
}
