package com.fh.utils;

public enum ServerEnum {


    USER_LOGIN_YANZHEGNMA_ERROR(1,"验证码错误"),
    ACCOUNT_OR_PWD_ISNULL(1001,"账号或者密码不存在"),
    ACCOUNT_ERROR(5001,"账号异常，请联系管理员")
    ,ACCOUNT_NOT_EXIST(1002,"账号不存在请联系管理员")
    ,ACCOUNT_NOT_INVALID(1003,"账号无效请联系管理员")
    ,PWD_ERROR(1004,"密码输入有误，请重新输入")
    ,RIGHT_NO(1005,"该用户没有权限访问，请联系管理员")
    ,EXPORT_NULL(7001,"导出数据是空的")
    ,TOKEN_TIMEOUT(6001,"token失效了，请重新登陆")
    ,SECRET_ERROR(6002,"token验证失败，非法请求")
    ,LEAVEL_DATE_ERROR(8001,"请假时间选择有误")
    ,APPROVAL_NO_RIJHT(8002,"没有权限审批")
    ,SESSION_TIMEOUT(8003,"session失效了")
    ,RIGHT_NO_TO(8004,"没有权限访问")

    ,PAY_STATUS_WAITING(0,"待支付")
    ,PAY_STATUS_FINISH(1,"已支付")
    ,PAY_STATUS_ERROR(-1,"支付失败")
    ,USER_LOGIN_JWT_TIME(24,"H")
    ,SUCCESS(200,"成功")
    ,ERROR(500,"失败")
    ;
    private ServerEnum(Integer code, String message) {
        this.code=code;
        this.message=message;
    }
    private Integer code;
    private String message;


    public Integer getCode() {

        return code;
    }

    public String getMessage()
    {
        return message;
    }
}
