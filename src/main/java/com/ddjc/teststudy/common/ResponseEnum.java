package com.ddjc.teststudy.common;


/**
 *  是把所有有可能的情形 全都列举出来
 *  列举出 我的系统所有有可能会要他提示的信息i(情形)
 */
public enum ResponseEnum {

    // 在内部定义 提示信息的
    SUCCESS("200","成功"),
    USERNAME_NOT_FOUND("300","用户名不存在"),
    USERNAME_OR_PASSWORD_INVALIDATE("301","用户名或者密码错误"),
    SYSTEM_ERROR("500","发生未知异常，请联系管理员"),
    TEST("501","我就测试一下提示信息");
    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // 没有public  这个构造方法 不能用到外面去  只能在这个类中被使用（提示的信息 只能在内部生成）
    ResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
