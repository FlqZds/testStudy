package com.ddjc.common.RESTFUL;


/**
 * 是把所有有可能的情形 全都列举出来
 * 列举出 我的系统所有有可能会要他提示的信息i(情形)
 */
public enum ResponseEnum {

    // 在内部定义 提示信息的
    SUCCESS("200", "成功"),

    USAGE_NOT_FOUND("300", "用户不存在"),
    ACCOUNT_INVALIDATE("301", "账户校验异常"),
    PASSWORD_ERROR("302", "密码错误"),
    USER_NOT_LOGIN("303", "用户未登录"),
    USER_ALREADY_LOGIN("304", "用户已登录"),
    USER_ALREADY_EXIST("305", "用户已存在"),

    TOKEN_NOT_FOUND("801","Token不存在"),
    TOKEN_INVALIDATE("804","无效Token ,丢你老母"),
    TOKEN_EXPIRE("805","Token过期 ,请重新登录"),

    //    角色 权限 相关
    USER_ROLE_NOT_EXIST("307", "用户角色不存在"),
    USER_ROLE_ALREADY_EXIST("308", "用户角色已存在"),
    USER_ROLE_NOT_ENOUGH("309", "用户角色权限不足"),
    USER_ROLE_ALREADY_ENOUGH("310", "用户角色权限已足够"),
    USER_ROLE_NOT_ASSIGN("311", "用户角色未分配"),
    USER_ROLE_ALREADY_ASSIGN("312", "用户角色已分配"),


    //    业务错误

    BIZ_ERROR("600","业务错误"),


//    SMS相关

    SMS_SEND_ERROR("5502","短信发送失败"),

    SMS_CODE_ERROR("5530","短信验证码错误"),

//  上传，下载相关
    LOCAL_UPLOAD_ERROR("6784","本地上传失败"),
    LOCAL_DOWNLOAD_NOT_FOUND_ERROR("6684","下载文件失败,文件不存在"),
    LOCAL_DOWNLOAD_ERROR("6684","下载文件失败"),

    LOCAL_DOWNLOAD_RETURN_WARNING("6600","下载文件成功,返回警告"),

    OSS_UPLOAD_ERROR("7684","OSS上传失败"),


    // 系统错误

    PARAMETER_ERROR("400","参数错误"),

    DATA_NOT_FOUND("404","数据不存在"),

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
